package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class FetchJoinDemo
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

			// option 2 - Hibernate query with HQL

			// loading Instructor
			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i "
							+ " JOIN FETCH i.courses "
							+ " where i.id=:theInstructorId", Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();

			System.out.println("LO: Instructor loaded: " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// close the section
			session.close();

			System.out.println("\nLO: The session is now closed! \n");

			// get course for instructor
			System.out.println("LO: Courses: " + tempInstructor.getCourses());

			System.out.println("LO: Done!!");

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
