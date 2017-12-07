package com.chargingpoint.assignmnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath:spring-context.xml")
@ComponentScan("com.chargingpoint.assignmnet")
@PropertySource("classpath:application.properties")
public class AssignmnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmnetApplication.class, args);
	}

}
