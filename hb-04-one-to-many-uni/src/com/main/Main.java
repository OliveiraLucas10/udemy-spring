package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;

public class Main
{

	public static void main(String[] args)
	{

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{

			session.beginTransaction();

			/*
			 * Creation of data
			 * // create a course
			 * Course temCourse = new Course("Pacman - How to Score One Million Points");
			 * // add some reviews
			 * temCourse.addReview(new Review("Great course . . . love it"));
			 * temCourse.addReview(new Review("Cool course, job well done"));
			 * temCourse.addReview(new Review("What a dumb course, you are an idiot!"));
			 * // save the course . . . and leverage the cascade all
			 * System.out.println("LO: Saving the course: " + temCourse);
			 * System.out.println("LO: Saving the reviews: " + temCourse.getReviews());
			 * session.save(temCourse);
			 */

			/*
			 * Getting course and reviews
			 * // get the course
			 * int theId = 10;
			 * Course tempCourse = session.get(Course.class, theId);
			 * // print the course
			 * System.out.println("LO: Course: " + tempCourse);
			 * // print the course reviews
			 * System.out.println("LO: Reviews: " + tempCourse.getReviews());
			 */

			/*
			 * Deleting course and reviews
			 */
			// get the course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// print the course
			System.out.println("LO: Course: " + tempCourse);
			
			// print the course reviews
			System.out.println("LO: Reviews: " + tempCourse.getReviews());

			// deleting the course
			System.out.println("LO: Deleting the course . . .");
			session.delete(tempCourse);

			session.getTransaction().commit();

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
