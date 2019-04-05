package com.valtech.carassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy 
public class CarAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarAssignmentApplication.class, args);
	}

}
