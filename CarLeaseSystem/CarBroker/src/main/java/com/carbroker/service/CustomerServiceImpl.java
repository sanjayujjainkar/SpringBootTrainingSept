package com.carbroker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.carbroker.entity.Customer;
import com.carbroker.exception.ResourceNotFoundException;
import com.carbroker.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}
	
	@Override
	public Customer getCustomer(Integer id) {
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "id", id));
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		Customer existingCustomer = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "id", id));
		existingCustomer.setName(customer.getName());
		existingCustomer.setStreet(customer.getStreet());
		existingCustomer.setHomenumber(customer.getHomenumber());
		existingCustomer.setPlace(customer.getPlace());
		existingCustomer.setZipcode(customer.getZipcode());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());
		return existingCustomer;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		Customer customer = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Customer", "id", id));
		repository.delete(customer);
		return customer;
	}

}
