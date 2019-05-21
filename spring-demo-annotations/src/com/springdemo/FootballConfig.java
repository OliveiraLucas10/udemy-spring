package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FootballConfig
{

	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}

	@Bean
	public Coach footballCoach()
	{
		return new FootballCoach(sadFortuneService());
	}

}
