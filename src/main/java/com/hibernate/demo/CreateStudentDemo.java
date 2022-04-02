package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

public class CreateStudentDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //use the session object to save Java object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Paul", "Wall", "paul@luvtocode.com");

            //creat a student object
            session.beginTransaction();

            //start a transaction
            System.out.println("Saving student");
            session.save(tempStudent);

            //save the student object
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
