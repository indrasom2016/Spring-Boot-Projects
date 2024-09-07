package com.indrasom.springboot.crudrestdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.indrasom.springboot.crudrestdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
