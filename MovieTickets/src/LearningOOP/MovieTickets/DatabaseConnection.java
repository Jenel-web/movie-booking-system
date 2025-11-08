package LearningOOP.MovieTickets;
import java.sql.*;

public class DatabaseConnection {
  
        // Your database info
        private static final String URL = "jdbc:mysql://localhost:3306/movie_booking";
        private static final String USER = "root";           // replace with your DB username
        private static final String PASSWORD = "password"; // replace with your DB password

    // Public static method to get a connection
    public static Connection getConnection() throws SQLException {
        try {
            // Optional: Load the MySQL JDBC driver (for older versions)
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }

        // Return a new connection
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

