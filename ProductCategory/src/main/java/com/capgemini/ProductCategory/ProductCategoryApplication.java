package com.capgemini.ProductCategory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@OpenAPIDefinition(
info = @Info(
title = "Product Service API",
version = "1.0",
description = "API documentation for Product Service"
)
)

@SpringBootApplication
@ComponentScan(basePackages = {
		 "com.capgemini.ProductCategory", 
	        "com.capgemini.controller",     
	        "com.capgemini.dto",         
	        "com.capgemini.repo" 
}) // add in the componentScan 
@EnableJpaRepositories(basePackages = "com.capgemini.repo")  // for the jparepositories add this
@EntityScan(basePackages = "com.capgemini.dto") // for the enities add this 
public class ProductCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCategoryApplication.class, args);
	}
	
	@Bean  
	public OpenAPI getOpenAPI() {
		return new OpenAPI() ; 
	}

}
