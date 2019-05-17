package com.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFileFortuneService implements FortuneService
{

	private String[] data;

	@Value("${file.f1}")
	private String f1;

	@Value("${file.f2}")
	private String f2;

	@Value("${file.f3}")
	private String f3;

	private Random myRandom = new Random();

	@PostConstruct
	private void setUpData()
	{
		// System.out.println("inside of setUpData");
		data = new String[3];
		data[0] = f1;
		data[1] = f2;
		data[2] = f3;
	}

	public RandomFileFortuneService()
	{
		// System.out.println("inside of RandomFileFortuneService");
		setUpData();
	}

	@Override
	public String getFortune()
	{
		// System.out.println("inside of getFortune");
		int index = myRandom.nextInt(data.length);

		return data[index];
	}

}
