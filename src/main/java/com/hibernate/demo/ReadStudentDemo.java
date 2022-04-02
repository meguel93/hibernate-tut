package com.hibernate.demo;

import com.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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
            Student tempStudent = new Student("Daffy", "Duck", "duck@luvtocode.com");

            //creat a student object
            session.beginTransaction();

            //start a transaction
            System.out.println("Saving the student");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //save the student object
            //commit transaction
            session.getTransaction().commit();

            //New code

            //find out the student's id: primary key
            System.out.println("Save student. Generated id: "+ tempStudent.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: "+ tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            //commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
