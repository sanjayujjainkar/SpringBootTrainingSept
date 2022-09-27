package com.flightadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightadmin.entity.AirLine;
import com.flightadmin.repo.AirLineRepository;

public class AirLineServiceImpl implements AirLineService {
	
	@Autowired
	AirLineRepository repository;

	@Override
	public List<AirLine> getAllAirLines() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public AirLine addAirLine(AirLine airline) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirLine updateAirLine(Integer id, AirLine airLine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirLine deleteAirLine(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
