package com.proyecto.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.proyecto.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserController.class)
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		//PasswordUtils.GenerateRandomPassword();
	}

}

