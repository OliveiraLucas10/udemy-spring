package com.springdemo;

public class FootballCoach implements Coach
{

	private FortuneService fortuneService;

	private int numberOfHits = 7;

	public int getNumberOfHits()
	{
		return numberOfHits;
	}

	public FootballCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Let's kill they!!";
	}

	@Override
	public String getDailyFortune()
	{
		return fortuneService.getFortune();
	}

}
