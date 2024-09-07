package com.indrasom.mapcruddemo.dao;

import com.indrasom.mapcruddemo.entity.Instructor;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
}
