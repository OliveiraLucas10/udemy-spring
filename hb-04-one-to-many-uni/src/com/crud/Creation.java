package com.crud;

import org.hibernate.Session;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class Creation
{

	public Creation()
	{

	}

	public static void creation(Session session)
	{
		session.beginTransaction();

		// create the objects
		Instructor tempInstructor = new Instructor("Lucas", "Oliveira", "oliveiraborgeslucas@gmail.com");
		InstructorDetail temInstructorDetail = new InstructorDetail("My Channel", "Play AF");

		Instructor tempInstructor2 = new Instructor("Madhu", "Patel", "madhu@gmail.com");
		InstructorDetail temInstructorDetail2 = new InstructorDetail("My Channel", "Guitar");

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// associate the objects
		tempInstructor.setInstructorDetail(temInstructorDetail);
		tempInstructor2.setInstructorDetail(temInstructorDetail2);

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Instructor save: " + tempInstructor);
		session.save(tempInstructor);
		session.save(tempInstructor2);

		session.save(tempCourse1);
		session.save(tempCourse2);

		// commit transaction
		session.getTransaction().commit();

	}

}
