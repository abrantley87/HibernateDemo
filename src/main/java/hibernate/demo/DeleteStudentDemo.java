package hibernate.demo;

import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();


        Session session = factory.getCurrentSession();


        try {

            int studentId = 1;

            session = factory.getCurrentSession();

            session.beginTransaction();

            Student myStudent = session.get(Student.class,studentId);
            System.out.println(myStudent);

            session.delete(myStudent);

            session.getTransaction().commit();

//            session.createQuery("delete from Student where id=1").executeUpdate();

            session.close();
            System.out.println("Done!");


        } finally {
            session.close();
        }


    }
}
