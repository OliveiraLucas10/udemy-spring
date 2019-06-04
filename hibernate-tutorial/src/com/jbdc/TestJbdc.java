package com.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJbdc
{

	public static void main(String[] args)
	{
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSl=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";

		try
		{
			System.out.println("connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("connetion successful!!!");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
