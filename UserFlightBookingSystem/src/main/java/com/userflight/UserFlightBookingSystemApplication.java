package com.userflight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserFlightBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserFlightBookingSystemApplication.class, args);
	}

}
