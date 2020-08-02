package com.proyecto.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.proyecto.controller"})
@ComponentScan(basePackages = {"com.proyecto.service"})
@ComponentScan(basePackages = {"com.proyecto.dao"})
@ComponentScan(basePackages = {"com.proyecto.swagger"})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
	}

}

