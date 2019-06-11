package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class AddCoursesForJanDemo
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
			int studentId = 2;
			Student temStudent = session.get(Student.class, studentId);
			System.out.println("\nLO: Loaded student: " + temStudent);
			System.out.println("LO: Courses: " + temStudent.getCourses());

			// create more courses
			Course temCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course temCourse2 = new Course("Atari 2600 - Game Development");

			// add student to courses
			temCourse1.addStudent(temStudent);
			temCourse2.addStudent(temStudent);

			// save the courses
			System.out.println("\nLO: Saving the courses . . .");
			session.save(temCourse1);
			session.save(temCourse2);

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
