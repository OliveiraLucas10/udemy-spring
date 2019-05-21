package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach
{

	private FortuneService fortuneService;

	@Value("${sp.1}")
	private String email;

	@Value("${sp.2}")
	private String team;

	public SwimCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

	
	public String getEmail()
	{
		return email;
	}

	
	public String getTeam()
	{
		return team;
	}
	
	

}
