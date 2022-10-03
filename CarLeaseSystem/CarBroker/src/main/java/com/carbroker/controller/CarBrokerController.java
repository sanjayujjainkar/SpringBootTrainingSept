package com.carbroker.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.carbroker.entity.CarUsageContract;
import com.carbroker.entity.Customer;
import com.carbroker.service.CustomerService;

@RequestMapping("/broker")
@RestController
public class CarBrokerController {
	
	private static final String CAR_SERVICE_URL = "http://car-service/admin";
	private static final String LEASE_SERVICE_URL =  "http://leaserate-service/lease/rate";
	
	@Autowired
	private CustomerService service;
	@Autowired
	private RestTemplate restTemplate;
	
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
	
	@GetMapping("/getCars")
	public String getCars() {
		String requestURL = CAR_SERVICE_URL+"/getCars";
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(requestURL, HttpMethod.GET, entity, String.class);
		String cars = response.getBody();
		System.out.println("List of Cars"+ cars + "\n");
		return cars;
	}
	
	@PostMapping("/leaserate")
	public String getLeaseRate(@RequestBody CarUsageContract carUsaeDetail) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<CarUsageContract> entity = new HttpEntity<CarUsageContract>(carUsaeDetail,headers);
		return restTemplate.exchange(
				LEASE_SERVICE_URL, HttpMethod.POST, entity, String.class).getBody();
		
	}
	
}
