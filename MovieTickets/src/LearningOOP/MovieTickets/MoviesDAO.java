package LearningOOP.MovieTickets;

import java.sql.*;

public class MoviesDAO {
    private Connection conn;

    public MoviesDAO(Connection conn)
    {
        this.conn = conn;
    }



    public void showMovies()
    {
        String sql = "SELECT * FROM movie";

        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt("movie_id");
                String title = rs.getString("title");
                String theater = rs.getString("theater");

                System.out.println("Movie ID: " + id + " || Title : " + title + " || Location : " + theater);

            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean isMovieFound(int movie_id)
    {
        String sql = "SELECT movie_id FROM movie WHERE movie_id = ?";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, movie_id);
            ResultSet rs = stmt.executeQuery();

           return rs.next();
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }    
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
   
    }




