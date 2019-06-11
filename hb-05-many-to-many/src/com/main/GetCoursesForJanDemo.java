package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class GetCoursesForJanDemo
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

			// get the student Jan form db
			int studentId = 1;
			Student temStudent = session.get(Student.class, studentId);
			System.out.println("\nLO: Loaded student: " + temStudent);
			System.out.println("LO: Courses: " + temStudent.getCourses());

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
