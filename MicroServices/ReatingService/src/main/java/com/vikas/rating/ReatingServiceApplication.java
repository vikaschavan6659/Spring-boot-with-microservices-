package com.vikas.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReatingServiceApplication.class, args);
	}

}
