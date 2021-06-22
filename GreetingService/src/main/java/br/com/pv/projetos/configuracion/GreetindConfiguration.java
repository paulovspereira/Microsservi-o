package br.com.pv.projetos.configuracion;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope // Anotação que gera dinamicamente
@ConfigurationProperties("greeting-service") // Anotação do spring sobre classe para definir que usar arquivo
												// cnfiguração "application.yml" para fazer o bin
											// Greeting-Service tem que ser está la no arquivo de configuração
public class GreetindConfiguration {

	private String greeting; // O conteundo do arquivo application.yml
	private String defaultValue;

	public GreetindConfiguration() {
	}

	public String getGreeting() {
		return greeting;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
