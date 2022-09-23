package com.secure.entity;

import java.util.Objects;

public class Employee {
	
	public String name;
	public String role;
	
	public Employee(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
	public Employee() {}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) obj;
		return Objects.equals(name, employee.name) && Objects.equals(role, employee.role);
	}
	
	
	

}
