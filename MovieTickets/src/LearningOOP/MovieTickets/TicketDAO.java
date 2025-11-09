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

        try
        {
          
            String CheckSeats = "SELECT vip_seat_limit, vip_seat_booked, reg_seat_limit, reg_seat_booked FROM movie WHERE movie_id = ?";
            PreparedStatement checkstmt = conn.prepareStatement(CheckSeats);
            checkstmt.setInt(1, movie_id);
            ResultSet checkRS = checkstmt.executeQuery();
            checkRS.next();
            int vip_seat_limit = checkRS.getInt("vip_seat_limit");
            int vip_seat_booked = checkRS.getInt("vip_seat_booked");
            int reg_seat_limit = checkRS.getInt("reg_seat_limit");
            int reg_seat_booked = checkRS.getInt("reg_seat_booked");

            if(seat_category.equalsIgnoreCase("VIP"))
            {
                if(vip_seat_booked >= vip_seat_limit)
                {
                    System.out.println("VIP section is already full. Please consider purchasing a regular ticket.");
                }

                else{
                    String sql = "INSERT INTO tickets (ticket_code, seat_category, movie_id, user_id) VALUES (?,?,?,?)";
                    PreparedStatement vipStmt = conn.prepareStatement(sql);
                    
                    vipStmt.setString(1, UUID.randomUUID().toString().substring(0,6));
                    vipStmt.setString(2, seat_category);
                    vipStmt.setInt(3, movie_id);
                    vipStmt.setInt(4, user_id);

                    vipStmt.executeUpdate(); 
                }
            }
            else{
                if(reg_seat_booked >= reg_seat_limit)
                {
                    System.out.println("Regular section is already full.");
                }
                else{
                    String sql = "INSERT INTO tickets (ticket_code, seat_category, movie_id, user_id) VALUES (?,?,?,?)";
                    PreparedStatement regStmt = conn.prepareStatement(sql);
                    regStmt.setString(1, UUID.randomUUID().toString().substring(0,6));
                    regStmt.setString(2, seat_category);
                    regStmt.setInt(3, movie_id);
                    regStmt.setInt(4, user_id);

                    regStmt.executeUpdate(); 
                }
            }
                String sql;

                if(seat_category.equalsIgnoreCase("VIP"))
                {
                    sql = "UPDATE movie SET vip_seat_booked = vip_seat_booked + 1 WHERE movie_id = ?";
                }
                else{
                    sql = "UPDATE movie SET reg_seat_booked = reg_seat_booked + 1 WHERE movie_id = ?";
                }

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, movie_id);
    
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

    public void showMovieTickets(int movie_id)
    {
        String sql = """
                     SELECT user_name, title, ticket_code, seat_category
                    FROM tickets
                    JOIN users ON tickets.user_id = users.user_id
                    JOIN movie ON tickets.movie_id = movie.movie_id
                    WHERE movie.movie_id = ?;
                     """;
        
        try(PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, movie_id);
            ResultSet rs = stmt.executeQuery();

            boolean hasTickets = false;
            while(rs.next())
            {
                hasTickets = true;
                String ticket_code = rs.getString("ticket_code");
                String user_name = rs.getString("user_name");
                String title = rs.getString("title");
                String seat_category = rs.getString("seat_category");

                System.out.println("Ticket ID: " + ticket_code + " || Name: " + user_name + " || Title: " + title + " || Seat: " + seat_category);
            }

            if(!hasTickets)
            {
                System.out.println("There are currently no tickets in this movie.");
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void cancelTicket(String ticket_code)
    {

        //kukuha ng isang row gamit ticket code
        try{
        String sql = """
                SELECT movie_id, seat_category 
                FROM tickets where ticket_code = ?
                """;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ticket_code);
        ResultSet rs = stmt.executeQuery();
        

        if(rs.next())
        {
            int movie_id = rs.getInt("movie_id");
            String seat_category = rs.getString("seat_category");

            String deletesql = "DELETE FROM tickets WHERE ticket_code = ?;";
            PreparedStatement deleteStmt = conn.prepareStatement(deletesql);
            deleteStmt.setString(1, ticket_code);
            
            int deleted = deleteStmt.executeUpdate();

            if(deleted > 0 )
            {
                System.out.println("Ticket deleted successfully.");
            }
            else{
                System.out.println("Ticket does ddnot exist.");
                return;
            }
            String cancelSql;

            if(seat_category.equalsIgnoreCase("VIP"))
            {
                cancelSql = """
                                    UPDATE movie
                                    SET vip_seat_booked = vip_seat_booked - 1
                                    WHERE movie_id = ?
                        """;
            }
            else{
                cancelSql = """
                                    UPDATE movie
                                    SET reg_seat_booked = reg_seat_booked - 1
                                    WHERE movie_id = ?
                        """;
            }

            PreparedStatement cancelStmt = conn.prepareStatement(cancelSql);
            cancelStmt.setInt(1, movie_id);
            cancelStmt.executeUpdate();
        }
        }catch(SQLException e)
        {
            System.out.println("SQL Error : " + e.getMessage());
        }    
}
}