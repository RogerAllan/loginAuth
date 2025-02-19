package com.api.rest_code;

import com.api.rest_code.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.api.rest_code")
@EntityScan("com.api.rest_code.model")
@EnableJpaRepositories("com.api.rest_code.repositories")
@ConfigurationPropertiesScan("com.api.rest_code.config")
public class RestCodeApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestCodeApplication.class, args);
	}
	WebSecurityConfig webSecurityConfig = new WebSecurityConfig ();
}