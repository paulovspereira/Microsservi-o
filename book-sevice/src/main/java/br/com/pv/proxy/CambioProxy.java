package br.com.pv.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.pv.response.Cambio;

//Passa o nome do serviço
@FeignClient(name = "cambio-service", url = "localhost:8000") // Usa nome do cliente orbitario e o endereço para servidor cliente servidor Feign
public interface CambioProxy {

	//amout o valor total
	@GetMapping(value = "/cambio-service/{amout}/{from}/{to}")
	public Cambio getCambio(
			@PathVariable("amout") Double amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to);

}
