package TestConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String jdbcUrl = "jdbc:postgresql://localhost:5432/spring-hibernate-training";
        String user = "postgres";
        String pass = "fleereng44";

        try {
            System.out.println("Connecting to database " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            System.out.println("Connection succesful!");

        } catch(Exception exc) {
            exc.printStackTrace();
        }

    }

}
