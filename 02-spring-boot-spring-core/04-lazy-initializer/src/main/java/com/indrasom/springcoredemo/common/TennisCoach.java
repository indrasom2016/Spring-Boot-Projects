package com.indrasom.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	public TennisCoach()
	{
		System.out.println("Inside Constructor: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice Tennis for 1 hour!!";
	}

}
