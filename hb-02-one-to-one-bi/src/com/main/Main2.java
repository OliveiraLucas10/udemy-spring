package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class Main2
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

			// NEW

			// start a transaction
			session.beginTransaction();

			// get the instructorDetail object
			int theId = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("Instructor Detail: " + instructorDetail);

			// print associated instructor
			System.out.println("Instructor: " + instructorDetail.getInstructor());

			// now te's delete the instructor detail
			System.out.println("Deleting instructor detail: " + instructorDetail);

			// remove the associated object reference
			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);

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
