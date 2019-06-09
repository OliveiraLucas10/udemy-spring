package com.crud;

import org.hibernate.Session;

import com.entity.Instructor;

public class Read
{

	public static void readByPk(Session session, int PK)
	{
		session.beginTransaction();

		// loading employee according with PK
		Instructor instructor = session.get(Instructor.class, PK);

		System.out.println("LO: Instructor loaded: " + instructor);

		// get course for instructor

		System.out.println("LO: Courses: " + instructor.getCourses());

		session.getTransaction().commit();
	}

	

}
