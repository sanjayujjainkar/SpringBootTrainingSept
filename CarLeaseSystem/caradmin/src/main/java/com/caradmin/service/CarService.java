package com.caradmin.service;

import java.util.List;

import com.caradmin.entity.Car;

public interface CarService {
	
	public List<Car> getCars();
	
	public Car addCar(Car car);
	
	public Car updateCar(Integer id, Car car);
	
	public Car deleteCar(Integer id);

}
