package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach
{

	@Autowired
	@Qualifier("randomFileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout()
	{
		return "Practice your kick";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

}
