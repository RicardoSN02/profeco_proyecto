package com.clientes.clientesmicroservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientesMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesMicroservicioApplication.class, args);
	}

}
