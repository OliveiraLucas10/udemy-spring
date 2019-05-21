package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController
{

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}

	// new controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		// read the request parameter from HTML form
		String theName = request.getParameter("studantName");

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo!!! " + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

	// new controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studantName") String theName, Model model)
	{
		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey my friend from v3: " + theName;

		// add message to model
		model.addAttribute("message", result);

		return "helloworld";
	}

}
