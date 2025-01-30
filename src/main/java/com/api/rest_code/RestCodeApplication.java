package com.api.rest_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api.rest_code")
public class RestCodeApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestCodeApplication.class, args);
	}
}