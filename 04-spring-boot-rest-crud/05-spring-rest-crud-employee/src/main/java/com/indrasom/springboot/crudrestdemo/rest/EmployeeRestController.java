package com.indrasom.springboot.crudrestdemo.rest;

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

import com.indrasom.springboot.crudrestdemo.entity.Employee;
import com.indrasom.springboot.crudrestdemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService)
	{
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findbyId(@PathVariable int employeeId)
	{
		Employee theEmployee = employeeService.findbyId(employeeId);
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee id not found : "+employeeId);
		}
		return theEmployee;
	}
	
	//add mapping for POST /employees - add a new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		// force set Id to 0.
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	//add mapping for PUT /employees - update an employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		Employee dbEmployee = employeeService.save(theEmployee);
		
		return dbEmployee;
	}
	
	//delete mapping for DELETE /employees/{employeeId} - delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeebyId(@PathVariable int employeeId)
	{
		Employee theEmployee = employeeService.findbyId(employeeId);
		
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee not found : "+employeeId);
		}
		
		employeeService.deleteById(employeeId);
		return "Deleted Employee with ID : "+employeeId;
	}

}
