package com.carbroker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carbroker.entity.Customer;
import com.carbroker.service.CustomerService;

@RequestMapping("/broker")
@RestController
public class CarBrokerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		return service.getCustomers();
	}
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		return service.updateCustomer(id, customer);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public Customer deleteCustomer(@PathVariable Integer id) {
		return service.deleteCustomer(id);
	}
	
}
