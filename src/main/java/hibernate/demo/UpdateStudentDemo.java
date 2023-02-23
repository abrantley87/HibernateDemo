package hibernate.demo;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        // Create session factory

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();


        try {

            int studentId = 16;

            session = factory.getCurrentSession();

            //  start a transaction
            session.beginTransaction();

            System.out.println("\nGetting student with id: "+ studentId);

            Student myStudent = session.get(Student.class,studentId);
            myStudent.setFirstName("Scooby");

            session.getTransaction().commit();
            session.close();

            // NEW CODE
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // commit transaction
            session.getTransaction().commit();

            session.close();
            System.out.println("Done");



        } finally {
            factory.close();
        }





    }


}
