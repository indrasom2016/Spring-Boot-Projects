package com.indrasom.mapcruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.indrasom.mapcruddemo.dao.AppDAO;
import com.indrasom.mapcruddemo.entity.Course;
import com.indrasom.mapcruddemo.entity.Instructor;
import com.indrasom.mapcruddemo.entity.InstructorDetail;
import com.indrasom.mapcruddemo.entity.Review;

@SpringBootApplication
public class MapcruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapcruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourse(appDAO);
			//findCourseForInstrutor(appDAO);
			//findInstructorWithCourseJoinFetch(appDAO);
			//createInstructorWithCoursesReviews(appDAO);
			//findCourseWithReviews(appDAO);
			//findCourseWithReviewsJoinFetch(appDAO);
			deleteCourse(appDAO);
		};
	}
	
	private void deleteCourse(AppDAO appDAO) {
		
		int theId=11;
		System.out.println("Deleting Course with ID: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("DELETED Course with ID: "+theId);
	}

	private void findCourseWithReviewsJoinFetch(AppDAO appDAO) {
		int theId=10;
		System.out.println("Finding Course with ID: "+theId);
		
		Course tempCourse = appDAO.findCoursebyIdJoinFetch(theId);
		System.out.println("Course found: "+tempCourse);
		System.out.println("Associated Reviews: "+tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void findCourseWithReviews(AppDAO appDAO) {
		
		int theId=10;
		System.out.println("Finding Course with ID: "+theId);
		Course tempCourse = appDAO.findCourseById(theId);
		
		System.out.println("Course found: "+tempCourse);
		System.out.println("Associated Reviews: "+tempCourse.getReviews());
		System.out.println("Done");
		
	}

	private void createInstructorWithCoursesReviews(AppDAO appDAO) {
		
		Instructor tempInstructor = new Instructor("Ajinkya","Rahane","ajr@test.xyz");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/rahane1","Test Batting");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		Course tempCourse1 = new Course("Striaght Drive 101");
		Course tempCourse2 = new Course("Pull 201");
		
		Review tempC1Review1 = new Review("1st review for Straight Drive");
		Review tempC1Review2 = new Review("2nd review for Straight Drive");
		Review tempC2Review1 = new Review("1st review for Pull shot");
		Review tempC2Review2 = new Review("2nd review for Pull shot");
		
		tempCourse1.add(tempC1Review1);
		tempCourse1.add(tempC1Review2);
		tempCourse2.add(tempC2Review1);
		tempCourse2.add(tempC2Review2);
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		System.out.println("Saving Instructor");
		appDAO.save(tempInstructor);
		System.out.println("Done!");
		
	}

	private void findInstructorWithCourseJoinFetch(AppDAO appDAO) {
		
		int theId=1;
		System.out.println("Finding Instructor with ID: "+theId);
		Instructor tempInstructor = appDAO.findInstructorbyIdJoinFetch(theId);
		
		System.out.println("Instructor found: "+tempInstructor);
		System.out.println("Associated course: "+tempInstructor.getCourses());
		
		System.out.println("Done!");
	}

	private void findCourseForInstrutor(AppDAO appDAO) {
		
		int theId=1;
		System.out.println("Finding instructor with ID: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("Instructor found: "+ tempInstructor);
		
		List<Course> courses = appDAO.findCoursebyInstructorId(theId);
		tempInstructor.setCourses(courses);
		
		System.out.println("Associated courses: "+tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		
		int theId=1;
		System.out.println("Finding Instructor with id: "+theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("The Instructor found: "+tempInstructor);
		System.out.println("Associated course: "+tempInstructor.getCourses());
		
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		
		Instructor tempInstructor = new Instructor("Rohit","Sharma","rs45@test.xyz");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/rg_sharma","Batting");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		Course tempCourse1 = new Course("Cover Drive 101");
		Course tempCourse2 = new Course("Backfoot Punch 201");
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		//this will also save courses because of CascadeType.PERSIST
		
		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		
		int theId=1;
		System.out.println("Deleting...");
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Instructor Detail deleted with ID: "+theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		
		int theId=1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		System.out.println("Instructor Detail: "+tempInstructorDetail);
		System.out.println("Associated Instructor:"+tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		
		int theId=2;
		System.out.println("Deleting ...");
		appDAO.deleteInstructorById(theId);
		System.out.println("Instructor deleted with ID: "+theId);
	}

	private void findInstructor(AppDAO appDAO) {
		
		int theId=2;
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Retrieved instructor: "+tempInstructor);
		System.out.println("Associated Instructor Detail: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO)
	{
		Instructor tempInstructor = new Instructor("Virat","Kohli","vk18@test.xyz");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/im_vkohli","Cricket");
		
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		System.out.println("Saving Instructor"+tempInstructor);
		appDAO.save(tempInstructor);
		//this will save InstructorDetail also, due to CascadeType.ALL
	}
}
