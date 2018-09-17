package com.bilyoner.bilyonernumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class BilyonerNumberApplication {

	public static void main(String[] args) {
		SpringApplication.run(BilyonerNumberApplication.class, args);
	}
}
