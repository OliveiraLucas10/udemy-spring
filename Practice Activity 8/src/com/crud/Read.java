package com.crud;

import java.util.List;

import org.hibernate.Session;

import com.entity.Employee;

public class Read
{

	public static void readByPk(Session session, int PK)
	{
		session.beginTransaction();

		// loading employee according with PK
		Employee employee = session.get(Employee.class, PK);

		System.out.println("Employee loaded: " + employee);
	}

	public static void readByCompany(Session session, String company)
	{
		session.beginTransaction();

		List<Employee> theEmployee = session.createQuery("from Employee e where e.company ='" + company + "'").getResultList();

		for (Employee employee : theEmployee)
		{
			System.out.println("Employee found: " + employee);
		}

		session.getTransaction().commit();

	}

}
