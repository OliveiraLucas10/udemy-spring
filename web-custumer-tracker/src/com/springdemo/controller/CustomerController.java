package com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;

	// @RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{

		// get customer from the service
		List<Customer> theCustomers = customerService.getCustomers();

		// add the customer to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
