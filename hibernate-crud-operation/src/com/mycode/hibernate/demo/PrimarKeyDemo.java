package com.mycode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycode.hibernate.demo.entity.Student;

public class PrimarKeyDemo {

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
			System.out.println("Creating 3 students object ...");
			Student tempStudent1 = new Student("John", "Doe", "john@mycode.com");
			Student tempStudent2 = new Student("Peter", "Hseih", "peter@mycode.com");
			Student tempStudent3 = new Student("Jay", "Ho", "jay@mycode.com");
			
			// start a transaction
			session.beginTransaction();
					
			//save the student object
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
		
		

	}

}
