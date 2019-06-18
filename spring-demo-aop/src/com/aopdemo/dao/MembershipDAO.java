package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO
{

	public boolean addSillyMember()
	{
		System.out.println(getClass() + ": DOING STUFF: ADDING MEMBERSHIP ACCOUNT");

		return true;
	}

}
