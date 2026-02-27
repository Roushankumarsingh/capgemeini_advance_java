package com.capgemini.springbootbasic;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

}
