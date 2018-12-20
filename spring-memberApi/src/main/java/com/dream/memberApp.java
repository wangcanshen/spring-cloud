package com.dream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class memberApp {
	
	
	public static void main(String[] args) {
		SpringApplication.run(memberApp.class, args);
	}
}
