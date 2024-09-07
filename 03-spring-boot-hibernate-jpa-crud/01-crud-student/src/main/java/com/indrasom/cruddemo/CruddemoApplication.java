package com.indrasom.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.indrasom.cruddemo.dao.StudentDAO;
import com.indrasom.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}
	
	private void deleteAllStudents(StudentDAO studentDAO) {
		
		System.out.println("Deleting all students...");
		int rowCount = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+rowCount);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		studentDAO.delete(studentId);
		System.out.println("Deleted student with ID "+studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		
		//retrieve student by Id
		int id=1;
		System.out.println("Retrieving Student with Id: "+id);
		Student myStudent = studentDAO.findByID(id);
		
		//change firstName
		System.out.println("Updating student..");
		myStudent.setFirstName("John");
		
		//update student
		studentDAO.update(myStudent);
		System.out.println("Student updated: "+myStudent);
		
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		
		for(Student temp : theStudents)
		{
			System.out.println(temp);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		
		List<Student> theStudents = studentDAO.findAll();
		
		for(Student temp : theStudents)
		{
			System.out.println(temp);
		}
		
	}

	private void readStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating a new student object");
		Student tempStudent=new Student("Daffy","Duck","daffy@xyz.com");
		
		System.out.println("Saving student.");
		studentDAO.save(tempStudent);
		
		int theID=tempStudent.getId();
		System.out.println("Saved student - Generated ID "+theID);
		
		System.out.println("Retrieving student with ID "+theID);
		Student myStudent = studentDAO.findByID(theID);
		
		System.out.println("Found student : "+myStudent);
		
	}

	private void createMultipleStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating new student object.");
		Student tempStudent1 = new Student("John", "Doe","jd@test.xyz");
		Student tempStudent2 = new Student("Paul", "Doe","pd@test.xyz");
		Student tempStudent3 = new Student("Mike", "Doe","mkd@test.xyz");
		
		System.out.println("Saving students.");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	
	private void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Creating new student object.");
		Student tempStudent = new Student("Indrasom", "Majumdar","test@test.xyz");
		
		System.out.println("Saving student.");
		studentDAO.save(tempStudent);
		
		System.out.println("Saved Student: "+tempStudent.getId());
	}

}
