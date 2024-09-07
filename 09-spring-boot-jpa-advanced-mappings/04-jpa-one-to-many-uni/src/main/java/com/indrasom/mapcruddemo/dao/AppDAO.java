package com.indrasom.mapcruddemo.dao;

import java.util.List;

import com.indrasom.mapcruddemo.entity.Course;
import com.indrasom.mapcruddemo.entity.Instructor;
import com.indrasom.mapcruddemo.entity.InstructorDetail;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
	
	InstructorDetail findInstructorDetailById(int id);
	
	void deleteInstructorDetailById(int id);
	
	List<Course> findCoursebyInstructorId(int id);
	
	Instructor findInstructorbyIdJoinFetch(int id);
	
	Course findCourseById(int id);
	
	Course findCoursebyIdJoinFetch(int id);
	
	void deleteCourseById(int id);
}
