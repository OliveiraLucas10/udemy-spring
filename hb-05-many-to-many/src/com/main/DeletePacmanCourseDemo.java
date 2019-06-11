package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class DeletePacmanCourseDemo
{

	public static void main(String[] args)
	{

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetail.class)
						.addAnnotatedClass(Course.class)
						.addAnnotatedClass(Review.class)
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try
		{
			// start transaction
			session.beginTransaction();

			// get the Pacman course form db
			int courseId = 10;
			Course temCourse = session.get(Course.class, courseId);

			System.out.println("\nLO: Course: " + temCourse);
			System.out.println("LO: Students: " + temCourse.getStudents());

			// deleting course
			System.out.println("\nLO: Deleting course . . .");
			session.delete(temCourse);

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
			// add clean up
			session.close();
			factory.close();
		}
	}

}
