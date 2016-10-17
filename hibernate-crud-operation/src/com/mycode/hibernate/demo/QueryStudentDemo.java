package com.mycode.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.mycode.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		//create session factory
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
					
			// start a transaction
			session.beginTransaction();
					
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// query the students whose last name is "Doe"
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();
			
			// display the students
			System.out.println("\n\n Student who has last name of Doe");
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			
			// query students: lastName = 'Doe' OR FirstName = 'Dinesh'
			theStudents = 
					session.createQuery("from Student s where"
							+ " s.lastName='Doe' OR s.firstName='Dinesh'").getResultList();
			
			// display the students
			System.out.println("\n\n Student who has last name of Doe oR firstName is Dinesh");
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}
		finally {
			factory.close();
		}
		
		

	}

}
