package LearningOOP.MovieTickets;

import java.sql.*;

public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn)
    {
        this.conn = conn;
    }

    public void addUser(User user)
    {
        String sql = "INSERT INTO users (user_name, username) VALUES(?, ?)";

        try( PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUserName());
            stmt.executeUpdate();
            System.out.println("User added successfully!");
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }    
    }

    public int getUserIDByUserName(String username)
    {
        String sql = "SELECT user_id FROM users where username = ? ";

        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return rs.getInt("user_id");
            }
            else{
                return -1;
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
