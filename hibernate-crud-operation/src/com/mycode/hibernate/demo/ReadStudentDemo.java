package com.mycode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycode.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create a student object
			System.out.println("Creating new student object ...");
			Student tempStudent = new Student("Dinesh", "Madhup", "dinesh@mycode.com");
			
			// start a transaction
			session.beginTransaction();
					
			//save the student object
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
			//My New Code - Reading student
			
			//Find out the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// Get a new Session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\n Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class,  tempStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
		
		

	}

}
