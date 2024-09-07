package com.indrasom.cruddemo.dao;

import java.util.List;

import com.indrasom.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findByID(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
	void delete(Integer id);
	
	int deleteAll();
}
