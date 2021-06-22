package br.com.pv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


//Feigné um cliente serviço da WEB declarativo
@SpringBootApplication
@EnableFeignClients // Enibe o feign
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
