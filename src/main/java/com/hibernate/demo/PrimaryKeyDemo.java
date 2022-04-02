package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            //Create 3 new studnes
            System.out.println("Creating new student object...");
            Student tempStudent1 = new Student("John", "Doe", "john@luvtocode.com");
            Student tempStudent2 = new Student("Mary", "Wall", "mary@luvtocode.com");
            Student tempStudent3 = new Student("Bonita", "Apple", "bonita@luvtocode.com");

            //creat a student object
            session.beginTransaction();

            //start a transaction
            System.out.println("Saving student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //save the student object
            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
