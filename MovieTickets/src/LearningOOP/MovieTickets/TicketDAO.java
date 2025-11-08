package LearningOOP.MovieTickets;

import java.sql.*;
import java.util.UUID;

public class TicketDAO {
    private Connection conn;

    public TicketDAO(Connection conn)
    {
        this.conn = conn;
    }


    public void bookTicket(String seat_category, int movie_id, int user_id)
    {
        String sql = "INSERT INTO tickets (ticket_code, seat_category, movie_id, user_id) VALUES (?,?,?,?)";

        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, UUID.randomUUID().toString().substring(0,6));
            stmt.setString(2, seat_category);
            stmt.setInt(3, movie_id);
            stmt.setInt(4, user_id);

            stmt.executeUpdate();    
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }



    public void getTicketsOfUser(String username)
    {
        String sql = 
        """
        SELECT user_name, title, ticket_Code 
        FROM tickets 
        JOIN users ON tickets.user_id = users.user_ID
        JOIN movie on tickets.movie_id = movie.movie_id
        WHERE users.username = ?

                """;

        try( PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            boolean hasTickets = false;

            while(rs.next())
            {   
                hasTickets = true;
                String ticket_code = rs.getString("ticket_code");
                String user_name = rs.getString("user_name");
                String title = rs.getString("title");
                String seat_category = rs.getString(2);

                System.out.println("Ticket ID: " + ticket_code + " || Name: " + user_name + " || Title: " + title + " || Seat: " + seat_category);
            }

            if(!hasTickets)
            {
                System.out.println("User have no current booking.");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }    
    }

    
}