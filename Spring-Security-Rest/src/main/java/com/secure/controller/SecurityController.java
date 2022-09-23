package com.secure.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secure.entity.Employee;

@RestController
public class SecurityController {
	
	
	@GetMapping("/get")
	public String getDetail() {
		return "Get employee";
	}
	
	@PostMapping("/post")
	public Employee postEmployee(@RequestBody Employee newEmployee) {
		return newEmployee;
	}
	
	@PutMapping("/put/{name}")
	public String putEmployee(@RequestBody Employee newEmployee, @PathVariable String name) {
		return newEmployee.toString() + " is updated with Name:" + name;
	}
	
	@DeleteMapping("/delete/{name}")
	public String deleteEmployee(@PathVariable String name) {
		return "Employee deleted with name:" + name;
	}
	
	@GetMapping("/path/{name}")
	public String getPathVariable(@PathVariable String name) {
		return "Path Variable is:"+name;
	}
	
	@GetMapping("/request")
	public String getRequestParam(@RequestParam(name="name", required = true, defaultValue = "Sanjay") String name) {
		return "Request Param:"+name;
	}
			

}
