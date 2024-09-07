package com.indrasom.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indrasom.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	private Coach anotherCoach;
	
	@Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach, @Qualifier("cricketCoach")Coach theanotherCoach)
	{
		System.out.println("Inside Constructor: "+getClass().getSimpleName());
		myCoach=theCoach;
		anotherCoach=theanotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout()
	{
		return myCoach.getDailyWorkout();
	}
	
	@GetMapping("/check")
	public String checkScope()
	{
		return "Checking instances myCoach==anotherCoach : "+(myCoach==anotherCoach);
	}
}
