package com.Geekster.ToDo_Project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ToDoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoProjectApplication.class, args);
	}

}
