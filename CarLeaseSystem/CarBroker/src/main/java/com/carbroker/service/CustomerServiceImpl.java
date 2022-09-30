package com.carbroker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carbroker.entity.Customer;
import com.carbroker.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository repository;

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		Optional<Customer> custemp = repository.findById(id);
		Customer oldCustomer = custemp .get();
		oldCustomer.setName(customer.getName());
		oldCustomer.setStreet(customer.getStreet());
		oldCustomer.setHomenumber(customer.getHomenumber());
		oldCustomer.setPlace(customer.getPlace());
		oldCustomer.setZipcode(customer.getZipcode());
		oldCustomer.setEmail(customer.getEmail());
		oldCustomer.setPhone(customer.getPhone());
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		Optional<Customer> custemp = repository.findById(id);
		Customer customer = custemp.get();
		repository.delete(customer);
		return customer;
	}

}
