package com.caradmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caradmin.entity.Car;
import com.caradmin.service.CarService;

@RestController
@RequestMapping("/admin")
public class CarController {
	
	@Autowired
	private CarService service;
	
	@GetMapping("/getCars")
	public List<Car> getCars() {
		return service.getCars();
	}
	
	@PostMapping("/addCar")
	public Car addCar(@RequestBody Car car) {
		return service.addCar(car);
	}
	
	@PutMapping("/updateCar/{id}")
	public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
		return service.updateCar(id, car);
	}
	
	@DeleteMapping("/deleteCar/{id}")
	public Car deleteCar(@PathVariable Integer id) {
		return service.deleteCar(id);
	}

}
