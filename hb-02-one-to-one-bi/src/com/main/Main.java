package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
			/*
			 * OLD
			 * // Creation.creation(session);
			 * // Read.readByPk(session, 1);
			 * // Delete.deleteByPk(session, "id", "3");
			 * // Delete.deleteByPk(session, 2);
			 */

			// NEW

			// start a transaction
			session.beginTransaction();

			// get the instructorDetail object
			int theId = 199;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// print associated instructor
			System.out.println("Instructor: " + instructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();

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
