package com.proyecto.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}

    private ApiInfo apiInfo() {

    	ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Swagger Example API",
                "Parte BackEnd de la aplicación del proyecto final de DAM",
                "1.0", "",
                new Contact("Antonio Marchante Hernán", "",
                        "antonio.marchante.hernan@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html"
        );

    	return apiInfo;
    }

}