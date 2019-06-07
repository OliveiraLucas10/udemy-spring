package com.crud;

import org.hibernate.Session;

import com.entity.Instructor;

public class Delete
{

	public static void deleteByPk(Session session, String columnName, String value)
	{
		session.beginTransaction();

		session.createQuery("delete from InstructorDetail where " + columnName + " = '" + value + "'").executeUpdate();

		session.getTransaction().commit();
	}

	public static void deleteByPk(Session session, int PK)
	{
		session.beginTransaction();

		// loading employee according with PK
		Instructor instructor = session.get(Instructor.class, PK);

		if (instructor != null)
		{
			System.out.println("Deleting: " + instructor);
			session.delete(instructor);
		}

		session.getTransaction().commit();
	}
	
	
	
}
