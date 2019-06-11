package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class CreateCourseAndStudentDemo
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

			session.beginTransaction();

			// Creation of data

			// create a course
			Course temCourse = new Course("Pacman - How to Score One Million Points");
			// save the course . . . and leverage the cascade all
			System.out.println("LO: Saving the course: " + temCourse);

			session.save(temCourse);

			System.out.println("LO: Saved the course");

			// create the student
			Student temStudent1 = new Student("Lucas", "Oliveira", "lo@gmail.com");
			Student temStudent2 = new Student("Jan", "Nascimento", "jn@gmail.com");

			// add student to the course
			temCourse.addStudent(temStudent1);
			temCourse.addStudent(temStudent2);

			// save the students
			System.out.println("\nLO: Saving students");
			session.save(temStudent1);
			session.save(temStudent2);
			System.out.println("\nLO: Students saved: " + temCourse.getStudents());

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
