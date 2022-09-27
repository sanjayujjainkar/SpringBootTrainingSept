package com.flightadmin.service;

import java.util.List;

import com.flightadmin.entity.AirLine;


public interface AirLineService {
	
	
	public List<AirLine> getAllAirLines();
	
	public AirLine addAirLine(AirLine airline);
	
	public AirLine updateAirLine(Integer id, AirLine airLine);
	
	public AirLine deleteAirLine(Integer id);
	
	
}
