package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crud.Creation;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class Main3
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
			/*
			 * OLD
			 * // Creation.creation(session);
			 * // Read.readByPk(session, 1);
			 * // Delete.deleteByPk(session, "id", "3");
			 * // Delete.deleteByPk(session, 2);
			 */
			Creation.creation(session);

			// commit transaction

			System.out.println("Done!!");

		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
