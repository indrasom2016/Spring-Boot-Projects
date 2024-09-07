package com.indrasom.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

	public CricketCoach()
	{
		System.out.println("Inside Constructor: "+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes!!!!";
	}
	
	@PostConstruct
	public void doStartupStuffs()
	{
		System.out.println("In doStartupStuffs : "+getClass().getSimpleName());
	}
	
	@PreDestroy
	public void doDestroyStuff()
	{
		System.out.println("In doDestroyStuff : "+getClass().getSimpleName());
	}

}
