package com.crud;

import org.hibernate.Session;

import com.entity.Course;

public class Delete
{

	public static void deleteByPk(Session session, String columnName, String value)
	{
		session.beginTransaction();

		session.createQuery("delete from InstructorDetail where " + columnName + " = '" + value + "'").executeUpdate();

		session.getTransaction().commit();
	}

	// deleting course
	public static void deleteByPk(Session session, int PK)
	{
		session.beginTransaction();

		// loading course according with PK
		Course tempCourse = session.get(Course.class, PK);
		System.out.println("Deleting: " + tempCourse);

		session.delete(tempCourse);

		session.getTransaction().commit();
	}

}
