package hibernate.demo;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        Session session = factory.getCurrentSession();


        try {
            System.out.println("Creating a new student object...");

            Student tempStudent = new Student("Andrew", "Brantley", "andrew@resourceinternational.com");

            session.beginTransaction();

            System.out.println("Saving student... " + tempStudent.getFirstName());

            session.save(tempStudent);

            System.out.println("Creating 3 student object...");
            Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");

            // save the student object
            System.out.println("Saving students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            session.close();
            System.out.println("Done!");


        } finally {
            session.close();
        }


    }
}
