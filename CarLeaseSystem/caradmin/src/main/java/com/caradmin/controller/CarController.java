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

/**
 * 
 * @author Sanjay Ujjainkar
 * <p> This class is a controller which exposes CRUD APIs to manager car record. 
 * Car owner will act act as admin who can execute all CRUD operation
 *
 */

@RestController
@RequestMapping("/admin")
public class CarController {
	
	@Autowired
	private CarService service;
	
	/**
	 * @apiNote : Path is "/getCars". This GET API returns list of cars
	 * @return list of all cars from MySQL DB.
	 */
	@GetMapping("/getCars")
	public List<Car> getCars() {
		return service.getCars();
	}
	
	/**
	 * @apiNote : POST API to add a car in persistent storage MySQL.
	 * @param car
	 * @return added car
	 */
	@PostMapping("/addCar")
	public Car addCar(@RequestBody Car car) {
		return service.addCar(car);
	}
	
	/**
	 * @apiNote : PUT API to update the car detail in persistent storage. 
	 * @param id of car to be edited/updated
	 * @param car object with updated record.
	 * @return updated car object.
	 */
	@PutMapping("/updateCar/{id}")
	public Car updateCar(@PathVariable Integer id, @RequestBody Car car) {
		return service.updateCar(id, car);
	}
	
	/**
	 * @apiNote : Delete API to delete a car with given id in persistent storage.
	 * @param id of car to be deleted.
	 * @return deleted car object 
	 */
	@DeleteMapping("/deleteCar/{id}")
	public Car deleteCar(@PathVariable Integer id) {
		return service.deleteCar(id);
	}

}
