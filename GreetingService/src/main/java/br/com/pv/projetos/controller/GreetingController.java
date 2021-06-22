package br.com.pv.projetos.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pv.projetos.configuracion.GreetindConfiguration;
import br.com.pv.projetos.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "%s, %s!"; //Parâmetro vai ser dinâmico do aruqivo de configucao
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired //Injetar o arquivo de configutração recuperando os valores de arquivo de configuração
	private GreetindConfiguration configuration;
	
	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value="name",
			defaultValue = "World") String name) {
		
		if(name.isEmpty()) name = configuration.getDefaultValue();
	
		return new Greeting(
					counter.incrementAndGet(),
					String.format(template, configuration.getGreeting(), name)// Parametrizado como está arquivo de configuracao
				);
	}
}
