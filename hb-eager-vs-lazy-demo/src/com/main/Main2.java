package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
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
						.addAnnotatedClass(Course.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{

			session.beginTransaction();

			int theId = 1;

			// loading Instructor according with PK
			Instructor instructor = session.get(Instructor.class, theId);

			System.out.println("LO: Instructor loaded: " + instructor);

			// option 1 - call get before close the session
			System.out.println("LO: Courses: " + instructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			// close the section
			session.close();

			System.out.println("\nLO: The session is now closed! \n");

			// get course for instructor
			System.out.println("LO: Courses: " + instructor.getCourses());

			System.out.println("Done!!");

		}
		catch (Exception exp)
		{
			exp.printStackTrace();
		}
		finally
		{
			// add clean up
			session.close();
			factory.close();
		}
	}

}
