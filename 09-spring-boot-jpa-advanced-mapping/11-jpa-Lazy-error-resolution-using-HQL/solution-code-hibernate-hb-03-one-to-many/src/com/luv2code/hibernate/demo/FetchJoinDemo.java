package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// ---------------------------------------------------------------------------------
			// option-2: Hibernate query with HQL

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query= session.createQuery("Select i from Instructor i"
														+ "JOIN FETCH i.course"
														+ "WHERE i.id=theInstructorId",
														Instructor.class);

			// Set parameter on query
			query.setParameter("theInstructorId",theId);

			// execute query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			// ---------------------------------------------------------------------------------
			System.out.println("Instructor: " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			// closing the session
			session.close();

			// Give an error because session is closed, we execute before session closed.
			// get courses for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());

			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





