package com.indrasom.springboot.crudrestdemo.service;

import java.util.List;

import com.indrasom.springboot.crudrestdemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findbyId(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
