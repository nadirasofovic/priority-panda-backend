package com.login.java.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.login.java.project")
@EntityScan(basePackages = "com.login.java.project")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
