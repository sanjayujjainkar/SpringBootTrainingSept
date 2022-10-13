package com.caradmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caradmin.entity.Car;
import com.caradmin.exception.ResourceNotFoundException;
import com.caradmin.repo.CarRepository;


/**
 * 
 * @author Sanjay Ujjainkar
 * @implNote CarServiceImpl is a Service that implements custom interface CarService. 
 * <p> This service exposes functions that interacts with CarRepository for actual DB updates. </p>
 * 
 *
 */

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarRepository repository;

	@Override
	public List<Car> getCars() {
		return repository.findAll();
	}
	
	@Override
	public Car getCar(Integer id) {
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Car", "id", id));
	}

	@Override
	public Car addCar(Car car) {
		return repository.save(car);
	}

	@Override
	public Car updateCar(Integer id, Car car) {
		Car existingCar = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Car", "id", id));
		existingCar.setMake(car.getMake());
		existingCar.setModel(car.getModel());
		existingCar.setVersion(car.getVersion());
		existingCar.setDoors(car.getDoors());
		existingCar.setGrossprice(car.getGrossprice());
		existingCar.setNetprice(car.getNetprice());
		return existingCar;
	}

	@Override
	public Car deleteCar(Integer id) {
		Car car = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Car", "id", id));
		//Car car = cartemp.get();
		repository.delete(car);
		return car;
	}

	

}
