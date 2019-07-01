package com.oliveira.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student
{

	private int id;

	private String firstName;

	private String lastName;

	private boolean active;

	private Address address;

	private String[] languages;

	public Student()
	{

	}

	public Address getAddress()
	{
		return address;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public int getId()
	{
		return id;
	}

	public String[] getLanguages()
	{
		return languages;
	}

	public String getLastName()
	{
		return lastName;
	}

	public boolean isActive()
	{
		return active;
	}

	public void setActive(boolean active)
	{
		this.active = active;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setLanguages(String[] languages)
	{
		this.languages = languages;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active + "]";
	}

}
