package br.com.ctfera.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //Annotationn para ativar o serviço de auto-discovery do Eureka
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
