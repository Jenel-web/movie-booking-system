package LearningOOP.MovieTickets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Your database info
        String url = "jdbc:mysql://localhost:3306/movie_booking";
        String username = "root";
        String password = "password";

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // error is here
            System.out.println("Driver loaded successfully!");

            // Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("✅ Connection successful!");

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL JDBC Driver not found. Add the JAR to your classpath.");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
