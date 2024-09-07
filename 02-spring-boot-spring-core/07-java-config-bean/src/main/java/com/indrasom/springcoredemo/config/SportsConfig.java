package com.indrasom.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.indrasom.springcoredemo.common.Coach;
import com.indrasom.springcoredemo.common.SwimCoach;

@Configuration
public class SportsConfig {
	
	@Bean("aquatic")
	public Coach swimCoach()
	{
		return new SwimCoach();
	}
}
