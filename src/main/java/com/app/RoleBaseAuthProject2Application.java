package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoleBaseAuthProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(RoleBaseAuthProject2Application.class, args);
	}
	
	@Bean
	public ModelMapper getModelmapper() {
		return new ModelMapper();
	}

}
