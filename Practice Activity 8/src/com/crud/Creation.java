package com.crud;

import org.hibernate.Session;

import com.entity.Employee;

public class Creation
{

	public Creation()
	{

	}

	public static void creationEmployee(Session session)
	{

		// create a employee
		System.out.println("Creating a new employee");
		Employee employee1 = new Employee("Marcus", "Rosa", "Tekann");
		Employee employee2 = new Employee("Kelvin", "RoTeixeirasa", "Dell");
		Employee employee3 = new Employee("Jan", "Nascimento", "Nada");

		// start a transacion
		session.beginTransaction();

		// saving employee
		System.out.println("Saving...");
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);

		// commit transaction
		session.getTransaction().commit();

	}

}
