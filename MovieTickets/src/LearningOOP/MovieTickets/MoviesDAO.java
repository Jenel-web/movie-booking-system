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
    
    public void removeMovie(int movie_id)
    {
        String sql = "DELETE FROM movie WHERE movie_id = ?";

        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, movie_id);
            int deleted = stmt.executeUpdate();

            if(deleted > 0)
            {
                System.out.println("Movie Deleted Successfully");   
            }
            else{
                System.out.println("Movie index not found!");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void addMovie(Movie movie)
    {
        String sql = """
                     INSERT INTO movie (title, theater) 
                     VALUES (?,?)
                     """;

        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getTheater());
            stmt.executeUpdate();

            System.out.println("Movie added successfully!");
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

}




