package com.crud;

import org.hibernate.Session;

import com.entity.Instructor;

public class Read
{

	public static void readByPk(Session session, int PK)
	{
		session.beginTransaction();

		// loading employee according with PK
		Instructor instructor = session.get(Instructor.class, PK);

		System.out.println("Employee loaded: " + instructor);
	}

	// public static void readByCompany(Session session, String company)
	// {
	// session.beginTransaction();
	//
	// List<Employee> theEmployee = session.createQuery("from Employee e where e.company ='" + company + "'").getResultList();
	//
	// for (Employee employee : theEmployee)
	// {
	// System.out.println("Employee found: " + employee);
	// }
	//
	// session.getTransaction().commit();
	//
	// }

}
