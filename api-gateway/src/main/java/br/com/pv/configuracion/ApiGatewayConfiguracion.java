package br.com.pv.configuracion;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuração de rotas para api gateway

@Configuration
public class ApiGatewayConfiguracion {

	// getter e setter
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		 // Ferramento de diagnotico que converte url em json
		return builder.routes()
				.route(p -> p.path("/cambio-service/**")// Gerenciamento de rotas urls
							.uri("lb://cambio-service"))// load balance do eureka
				.route(p -> p.path("/book-service/**")// Gerenciamento de rotas urls
						.uri("lb://book-service"))// load balance do eureka
				.build();
	}
}
