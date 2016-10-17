package com.mycode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycode.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// Get a new Session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student....");
			myStudent.setFirstName("Kim");
			
			//commit transaction
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//updating email for all students
			System.out.println("updating email for all students");
			session.createQuery("Update Student set email='softarica@gmail.com'")
					.executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
		
		

	}

}
