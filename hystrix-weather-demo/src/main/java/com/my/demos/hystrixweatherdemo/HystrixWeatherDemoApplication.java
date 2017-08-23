package com.my.demos.hystrixweatherdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class HystrixWeatherDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixWeatherDemoApplication.class, args);
	}
}
