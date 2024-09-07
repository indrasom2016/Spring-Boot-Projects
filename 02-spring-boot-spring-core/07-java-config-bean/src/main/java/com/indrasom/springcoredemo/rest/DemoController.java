package com.indrasom.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indrasom.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	
	@Autowired
	public DemoController(@Qualifier("aquatic")Coach theCoach)
	{
		System.out.println("Inside Constructor: "+getClass().getSimpleName());
		myCoach=theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout()
	{
		return myCoach.getDailyWorkout();
	}
}
