package LearningOOP.MovieTickets;
import java.util.ArrayList;

public class Cinema {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        ArrayList <Movie> movies = new ArrayList<>();


        //User Attributes
        
        void registerUser(User user)
        {
                users.add(user);
        }
       
        public ArrayList<User> getUsers()
        {
                return users;
        }
        
        public int findUser(String name)
        {       
            int index = 0;
            for(User user : users)
            {
                if(user.getName().equalsIgnoreCase(name))
                {
                        //System.out.println("User Found!");
                        return index;
                }
                index++;
            }
            return -1;
        }

        void showUserBookings(String name)
        {
                for(Ticket ticket : tickets)
                {
                        if(ticket.getUser().getName().equalsIgnoreCase(name))
                        {
                                System.out.println(ticket);
                        }
                }
        }
        

        //Movie Attributes
        public ArrayList<Movie> getMovies()
        {
                return movies;
        }
        

        void addMovie(Movie movie)
        {
                movies.add(movie);
        }

        void showMovies()
        {       
                int index = 1;
                for(Movie m : movies)
                {
                        System.out.println(index + ". " + m);
                        index++;
                }
        }

        public void removeMovie(int index)
        {
                index--;
                movies.remove(index);
        }

        public String validateMovieIteration(int index)
        {
                int iterate = 1;
                for(Movie movie : movies)
                {
                        if(iterate == index)
                        {
                                return movie.getTitle();
                        }
                        iterate++;
                }
                return null;
        }

        public void showTicketsInMovie(int index)
        {
                for(Ticket ticket : tickets)
                {
                        if(ticket.getMovie().getTitle().equalsIgnoreCase(validateMovieIteration(index)))
                        {
                                System.out.println(ticket);
                        }
                }
        }

        public boolean bookSeat(Movie movie, String category)
        {
                if(category.equalsIgnoreCase("VIP"))
                {
                        if(movie.getAvailableVipSeats() > 0)
                        {
                                movie.bookVIPSeats();
                                return true;
                        }
                        else{
                                System.out.println("There are no VIP seats left. Please consider booking a regular ticket.");
                        }
                }
                else if(category.equalsIgnoreCase("Regular"))
                {
                        if(movie.getAvailableRegularSeats() > 0)
                        {
                                movie.bookRegularSeats();;
                                return true;
                        }
                        else{
                                System.out.println("There are no Regular seats left.");
                        }
                }
                return false;
        }    

        public String validateSeat(char choice)
        {
                return (choice == 'y'? "VIP" : "Regular" );
        }

        //Tickets Attributes
        void bookTicket(Ticket ticket)
        {
                tickets.add(ticket);
        }

        void generateTicket(User user, Movie movie, String seatCategory)
        {
                Ticket ticket;
                bookSeat(movie, seatCategory);
                ticket = new Ticket(user, movie, seatCategory);
                bookTicket(ticket);  
                System.out.println(ticket);
        }
        
        public void displayMenu()
        {       
                System.out.println();
                System.out.println("MENU");
                System.out.println("1. Register User");
                System.out.println("2. Book a Ticket");
                System.out.println("3. Show User Bookings");
                System.out.println("4. Show Movie Tickets");
                System.out.println("5. Cancel Ticket");
                System.out.println("6. Add Movie (Admin)");
                System.out.println("7. Remove Movie (Admin)");
                System.out.println("6. Exit the program. \n");

        }


        public void cancelTicket(String name, String ID)
        {       
                while(true)
                {
                        for(Ticket ticket : tickets)
                        {
                                if(ticket.getUser().getName().equalsIgnoreCase(name) && ticket.getTicketID().equals(ID))
                                {
                                        if(ticket.getSeatCategory().equals("VIP"))
                                        {       
                                                ticket.getMovie().increaseVIPTicket();
                                        }
                                        else{
                                                ticket.getMovie().increaseRegularTicket();
                                        }
                                        tickets.remove(ticket);
                                        System.out.println("Ticket cancelled.");
                                        return;                            
                                }
                        }
                        System.out.println("Ticket cannot be found.");
                        return;
                }
        }

        public void removeMovieTickets(int index)
        {       
                String movieTitle = validateMovieIteration(index);
                //for(Ticket ticket : tickets)
                
                tickets.removeIf(ticket ->ticket.getMovie().getTitle().equals(movieTitle));
                // remove tickets if they have the removed title
                
        }

        // Admin Attributes
         public boolean verifyAdmin(Admin admin, String name, String password)
        {
                if(admin.getName().equals(name) && admin.getPassword().equals(password))
                {
                        return true;
                }
                return false;
        }
}


