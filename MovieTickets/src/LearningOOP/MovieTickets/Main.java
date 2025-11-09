package LearningOOP.MovieTickets;

import java.util.*;
import java.sql.*;
// testing commit
public class Main {

    public static void main(String[] args) {
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            UserDAO userDAO = new UserDAO(conn);
            TicketDAO ticketDAO = new TicketDAO(conn);
            MoviesDAO moviesDAO = new MoviesDAO(conn);
            Scanner in = new Scanner (System.in);
             
        int action;


        Cinema cinema = new Cinema();

        Admin admin = new Admin(); 
        outerLoop:
        while (true)
        {
            cinema.displayMenu();   
            try{
                System.out.print("Choose : ");
                action = in.nextInt();
                in.nextLine();
            }catch(InputMismatchException e)
            {
                System.out.println("Only Input Integers! Please try again.");
                in.nextLine();
                continue outerLoop;
            
            }
            
            
            switch(action)
                {

                    case 1:
                        System.out.println("==================================================");
                        System.out.println("Register a User: \n");
                        System.out.print("Name : ");
                        String name = in.nextLine();

                        System.out.print("Username : ");
                        String userName = in.nextLine();
    
                        User u = new User(name, userName);
                        userDAO.addUser(u);
                        break;
                    case 2: 
                        System.out.println("==================================================");
                        System.out.println("Booking a Ticket");

                        int movie_id = -1;
                        System.out.println("Enter the name of the user: ");
                        String user_name = in.nextLine();
                        int user_id = userDAO.getUserIDByUserName(user_name);

                        moviesDAO.showMovies();
                        try{
                            System.out.println("Enter the Movie ID: ");
                            movie_id = in.nextInt();
                            in.nextLine();
                        }catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input. Only integers are accepted!");
                            in.nextLine();
                        }

                        if(user_id == -1)
                        {
                            System.out.println("User cannot be found.");
                            break;
                        }
                        else if(!moviesDAO.isMovieFound(movie_id))
                        {
                            System.out.println("Movie ID cannot be found.");
                            break;
                        }
                        
                        else
                        {
                            System.out.println("Do you want a VIP seat? (y/n)");
                            char seat = in.nextLine().charAt(0);

                            String seat_category = cinema.validateSeat(seat);
                
                            ticketDAO.bookTicket(seat_category, movie_id, user_id);
                            System.out.println("Ticket booked successfully!");
                        }

                       
                        break;
                    case 3:
                        System.out.println("==================================================");

                        System.out.println("Show User Bookings");
                        System.out.println("What is the name of the user? ");
                        String username = in.nextLine();
                        
                        ticketDAO.getTicketsOfUser(username);
                        break;
                    case 4: 
                        System.out.println("==================================================");

                        System.out.println("Show Tickets in a Movie.");
                        int index = 0;

                        moviesDAO.showMovies();
                        try{
                            System.out.println("Enter movie index: ");
                            index = in.nextInt();
                            in.nextLine();
                        }catch(InputMismatchException e)
                        {
                            in.nextLine();
                        }
                        


                        if(!moviesDAO.isMovieFound(index))
                        {
                            System.out.println("Movie index cannot be found.");
                        }
                        else
                        {
                            ticketDAO.showMovieTickets(index);
                        }
                        
                        break;
                       
                    case 5:
                        System.out.println("==================================================");

                        System.out.println("Cancel a Ticket.");
                        
                        System.out.println("Enter the Ticket ID : ");
                        String ID = in.nextLine();

                        ticketDAO.cancelTicket(ID);
                        break;
                    case 6:
                        System.out.println("Verify Admin");

                        System.out.println("Enter admin name: ");
                        String adminName = in.nextLine();

                        System.out.println("Enter admin password: ");
                        String password = in.nextLine();

                        if(cinema.verifyAdmin(admin, adminName, password))
                        {
                            System.out.println("Enter Title : ");
                            String title = in.nextLine();

                            System.out.println("Enter Location: ");
                            String location = in.nextLine();

                            Movie m = new Movie(title, location);
                            moviesDAO.addMovie(m);
                        }
                        else
                        {
                            System.out.println("Wrong admin login credentials.");
                        }
                        break;
                    case 7:
                        System.out.println("Verify Admin");

                        System.out.println("Enter admin name: ");
                        adminName = in.nextLine();

                        System.out.println("Enter admin password: ");
                        password = in.nextLine();

                        if(cinema.verifyAdmin(admin, adminName, password))
                        {
                            moviesDAO.showMovies();
                            System.out.println("Enter Index of Movie to remove: ");
                            int removeIndex = in.nextInt();
                            in.nextLine();
                            //removeIndex--;
                            if(moviesDAO.isMovieFound(removeIndex))
                            {
                                moviesDAO.removeMovie(removeIndex);
                            }
                            else{
                                System.out.println("Movie index not found.");
                            }
                        }
                        else{
                        System.out.println("Wrong admin login credentials.");
                        }
                        break;
                    case 8:
                        System.out.println("Exiting the program..");
                        break outerLoop;
            }
        }
            conn.close();
            in.close();
        }catch( SQLException e)
        {
        System.out.println(e.getMessage());
        }

    
}
}