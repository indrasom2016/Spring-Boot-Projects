package com.indrasom.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	public String coachName;
	
	@Value("${team.name}")
	public String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Coach: "+coachName+", Team: "+teamName;
	}
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World";
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "Run for 1 km!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Today is your lucky day";
	}
}
