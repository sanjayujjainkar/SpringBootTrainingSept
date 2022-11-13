package com.flightadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.flightadmin.entity.AirLine;
import com.flightadmin.entity.Flight;
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
		return repository.save(airline);
	}

	@Override
	public AirLine updateAirLine(Integer id, AirLine airLine) {
		Optional<AirLine> oldAirLinetOp = repository.findById(id);
		AirLine oldAirline = oldAirLinetOp.get();
		oldAirline.setAirlineName(airLine.getAirlineName());
		oldAirline.setContactNumber(airLine.getContactNumber());
		oldAirline.setDescription(airLine.getDescription());
		repository.save(oldAirline);
		return oldAirline;
	}

	@Override
	public AirLine deleteAirLine(Integer id) {
		Optional<AirLine> existingAirlineOp = repository.findById(id);
		AirLine existingAirline = existingAirlineOp.get();
		repository.delete(existingAirline);
		return existingAirline;
	}
	
	

}
