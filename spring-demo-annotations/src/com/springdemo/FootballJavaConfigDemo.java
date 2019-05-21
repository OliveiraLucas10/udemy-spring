package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FootballJavaConfigDemo
{

	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FootballConfig.class);

		FootballCoach faCoach = context.getBean("footballCoach", FootballCoach.class);

		System.out.println(faCoach.getDailyWorkout());
		System.out.println(faCoach.getDailyFortune());
		System.out.println("Number of hits: " + faCoach.getNumberOfHits());

		context.close();

	}

}
