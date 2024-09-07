package com.indrasom.springboot.demomvcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showLeaders()
	{
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String showSystem()
	{
		return "systems";
	}
	
	@GetMapping("/access-denied")
	public String showDenied()
	{
		return "access-denied";
	}
}
