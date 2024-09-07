package com.indrasom.springboot.crudrestdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indrasom.springboot.crudrestdemo.dao.EmployeeDAO;
import com.indrasom.springboot.crudrestdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO)
	{
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}
	
	@Override
	public Employee findbyId(int theId) {
		
		return employeeDAO.findbyId(theId);
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		
		return employeeDAO.save(theEmployee);
	}
	
	@Transactional
	@Override
	public void deleteById(int theId) {
		
		employeeDAO.deleteById(theId);
	}

}
