package com.example.userauthapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserAuthAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthAppApplication.class, args);
	}

}
