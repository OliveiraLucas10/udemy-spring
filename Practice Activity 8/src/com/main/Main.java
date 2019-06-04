package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crud.Delete;
import com.entity.Employee;

public class Main
{

	public static void main(String[] args)
	{

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{

			// Creation.creationEmployee(session);
			// Read.readByPk(session, 2);
			// Read.readByCompany(session, "Tekann");
			// Delete.deleteByPk(session, 2);
			Delete.deleteByPk(session, "company", "Nada");

			System.out.println("Done!!");

		}
		finally
		{
			factory.close();
		}
	}

}
