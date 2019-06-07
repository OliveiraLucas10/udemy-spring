package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crud.Delete;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class Main
{

	public static void main(String[] args)
	{

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{

			// Creation.creation(session);
			// Read.readByPk(session, 1);
			// Delete.deleteByPk(session, "id", "3");
			Delete.deleteByPk(session, 2);

			System.out.println("Done!!");

		}
		finally
		{
			factory.close();
		}
	}

}
