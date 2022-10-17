package com.caradmin.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caradmin.service.CarService;
import com.caradmin.service.CarServiceImpl;

/**
@TestConfiguration
public class CarControllerTestConfig {

	@Bean
	public CarService service() {
		return new CarServiceImpl();
	}
	
}
*/
