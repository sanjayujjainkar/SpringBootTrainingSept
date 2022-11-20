package com.flightadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flightadmin.service.AirLineServiceImpl;

@Configuration
public class FlightConfig {
	
	@Bean
	public AirLineServiceImpl getAirLineService() {
		return new AirLineServiceImpl();
	}

}
