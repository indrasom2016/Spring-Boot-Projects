package com.indrasom.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.indrasom.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	public EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findByID(Integer id)
	{
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
		theQuery.setParameter("theData", theLastName);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		Student theStudent = entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		
		int numRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRows;
	}

}
