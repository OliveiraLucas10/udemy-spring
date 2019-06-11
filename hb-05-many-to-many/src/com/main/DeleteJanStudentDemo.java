package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class DeleteJanStudentDemo
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

			// get the Jan student form db
			int studentId = 2;
			Student temStudent = session.get(Student.class, studentId);

			System.out.println("\nLO: Student: " + temStudent);
			System.out.println("LO: Course: " + temStudent.getCourses());

			// deleting student
			System.out.println("\nLO: Deleting Student . . .");
			session.delete(temStudent);

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
