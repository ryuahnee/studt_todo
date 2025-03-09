package com.studytodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class StudytodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudytodoApplication.class, args);
	}

}
