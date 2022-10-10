package com.caradmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caradmin.entity.Car;
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
	public Car addCar(Car car) {
		return repository.save(car);
	}

	@Override
	public Car updateCar(Integer id, Car car) {
		Optional<Car> cartemp = repository.findById(id);
		Car oldCar = cartemp.get();
		oldCar.setMake(car.getMake());
		oldCar.setModel(car.getModel());
		oldCar.setVersion(car.getVersion());
		oldCar.setDoors(car.getDoors());
		oldCar.setGrossprice(car.getGrossprice());
		oldCar.setNetprice(car.getNetprice());
		return car;
	}

	@Override
	public Car deleteCar(Integer id) {
		Optional<Car> cartemp = repository.findById(id);
		Car car = cartemp.get();
		repository.delete(car);
		return car;
	}

	

}
