package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp
{

	public static void main(String[] args)
	{
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("soccerCoach", Coach.class);
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
