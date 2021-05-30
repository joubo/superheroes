package com.joubo.apisuperheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiSuperheroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSuperheroesApplication.class, args);
	}

}
