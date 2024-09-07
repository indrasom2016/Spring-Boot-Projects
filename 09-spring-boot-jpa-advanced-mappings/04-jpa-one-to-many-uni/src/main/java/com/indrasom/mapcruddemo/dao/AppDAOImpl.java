package com.indrasom.mapcruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indrasom.mapcruddemo.entity.Course;
import com.indrasom.mapcruddemo.entity.Instructor;
import com.indrasom.mapcruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		
		Instructor tempInstructor = entityManager.find(Instructor.class, id);
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
		entityManager.remove(tempInstructorDetail);
	}

	@Override
	public List<Course> findCoursebyInstructorId(int id) {
		
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id=:theData", Course.class);
		query.setParameter("theData", id);
		
		List<Course> courses = query.getResultList();
		
		return courses;
	}

	@Override
	public Instructor findInstructorbyIdJoinFetch(int id) {
		
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"where i.id = :theData", Instructor.class);
		query.setParameter("theData", id);
		
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	public Course findCourseById(int id) {
		
		return entityManager.find(Course.class, id);
	}

	@Override
	public Course findCoursebyIdJoinFetch(int id) {
		
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c "+"JOIN FETCH c.reviews "+"where c.id = :theData",Course.class);
		query.setParameter("theData", id);
		
		Course course = query.getSingleResult();
		return course;
	}

	@Override
	@Transactional
	public void deleteCourseById(int id) {
		
		Course tempCourse = entityManager.find(Course.class, id);
		entityManager.remove(tempCourse);
	}

}
