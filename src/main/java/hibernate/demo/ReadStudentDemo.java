package hibernate.demo;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // Create session factory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();


        try {

            // create a student object
            System.out.println("Creating a new student object...");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //  start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();


            System.out.println("Saved student. Generated id: " + tempStudent.getId());


            // now we get a new session
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            // retrieve student based on the id: primary key

            session.getTransaction().commit();

            // commit the transaction

            System.out.println("Done");


        } finally {
            factory.close();
        }


    }


}
