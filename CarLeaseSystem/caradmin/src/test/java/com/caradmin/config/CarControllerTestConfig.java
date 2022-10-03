package com.caradmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.caradmin.service.CarService;
import com.caradmin.service.CarServiceImpl;

@Configuration
public class CarControllerTestConfig {

	@Bean
	public CarService service() {
		return new CarServiceImpl();
	}
	
}
