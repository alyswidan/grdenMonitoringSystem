package com.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EntityScan(basePackages = {"com.model"} )
@EnableJpaRepositories(basePackages = {"com.model.database"})
@SpringBootApplication(scanBasePackages = { "com" })
public class Application {
	public static void main(String[] args) {

		
		SpringApplication.run(Application.class, args);

	}
}