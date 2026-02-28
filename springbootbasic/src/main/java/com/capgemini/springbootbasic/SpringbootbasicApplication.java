package com.capgemini.springbootbasic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

@SpringBootApplication // if we don't want to add this simply add 3 of them to execute 
//@Configuration
//@ComponentScan(basePackages = "com")
//@EnableAutoConfiguration
public class SpringbootbasicApplication {
	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpringbootbasicApplication.class, args);
		Doctor d = ioc.getBean(Doctor.class) ; 
		d.check();
	}
	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI() ;
	}

}
