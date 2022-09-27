package com.flightadmin.service;

import java.util.List;

import com.flightadmin.entity.Flight;

public interface FlightService {
	
	
	public List<Flight> getAllFlights();
	
	public Flight addFlight(Flight flight);
	
	public Flight updateFlight(Integer flightID, Flight flight);
	
	public Flight deleteFlight(Integer flightID);
	
	
}
