package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp
{

	public static void main(String[] args)
	{
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// Coach secondCoach = context.getBean("soccerCoach", Coach.class);

		// call method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// System.out.println("My second Coach: -> " + secondCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
