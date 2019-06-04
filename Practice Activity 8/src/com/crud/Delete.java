package com.crud;

import org.hibernate.Session;

public class Delete
{

	public static void deleteByPk(Session session, String columnName, String value)
	{
		session.beginTransaction();

		session.createQuery("delete from Employee where " + columnName + " = '" + value + "'").executeUpdate();

		session.getTransaction().commit();
	}
}
