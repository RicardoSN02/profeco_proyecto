package com.clientes.productosmicroservicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductosMicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosMicroservicioApplication.class, args);
	}

}
