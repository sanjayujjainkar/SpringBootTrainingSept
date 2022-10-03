package com.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarLeaseRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLeaseRateApplication.class, args);
	}

}
