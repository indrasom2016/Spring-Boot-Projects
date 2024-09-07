package com.indrasom.springboot.crudrestdemo.dao;

import java.util.List;

import com.indrasom.springboot.crudrestdemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findbyId(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
