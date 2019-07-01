package com.oliveira.jackson.json.demo;

public class Address
{

	private String street;

	private String city;

	private String state;

	private String zip;

	private String country;

	public Address()
	{

	}

	public String getCity()
	{
		return city;
	}

	public String getCountry()
	{
		return country;
	}

	public String getState()
	{
		return state;
	}

	public String getStreet()
	{
		return street;
	}

	public String getZip()
	{
		return zip;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}

	@Override
	public String toString()
	{
		return "Adress [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + "]";
	}

}
