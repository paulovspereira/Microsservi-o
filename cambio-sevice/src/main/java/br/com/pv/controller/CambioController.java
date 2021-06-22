package br.com.pv.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pv.model.Cambio;
import br.com.pv.reposittory.CambioRespository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

	@Autowired
	private Environment enviroment; // Interface que representa o ambiente no qual o aplicativo atual está sendo
									// executado

	@Autowired
	private CambioRespository repository;

	// http://localhost:8000/cambio-service/5/USD/BRL
	@GetMapping(value = "/{amout}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amout") BigDecimal amount, @PathVariable("from") String from,
			@PathVariable("to") String to) {

		var cambio = repository.findByFromAndTo(from, to);
		
		if (cambio == null)
			throw new RuntimeErrorException(null, "Currency Unsupported");

		var port = enviroment.getProperty("local.server.port");// Acessar varias informações sobre aplicação

		BigDecimal conversionFactor = cambio.getConversionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(amount); // Fazer X em BigDecimal
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));// Set no cambio redução a duas casas
																					// decimais
		cambio.setEnviroments(port);

		return cambio;
	}
}
