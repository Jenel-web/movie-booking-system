package LearningOOP.MovieTickets;
import java.util.ArrayList;

public class Cinema {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();
        ArrayList <Movie> movies = new ArrayList<>();

        void registerUser(User user)
        {
                users.add(user);
        }
       
        public ArrayList<Movie> getMovies()
        {
                return movies;
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
                        System.out.println("User Found!");
                        return index;
                }
                index++;
            }
            return -1;
        }

        void addMovie(Movie movie)
        {
                movies.add(movie);
        }

        void bookTicket(Ticket ticket)
        {
                tickets.add(ticket);
        }

        void showMovies()
        {
                for(Movie m : movies)
                {
                        System.out.println(m);
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

        void showUserBookings()
        {

        }

        public void displayMenu()
        {
                System.out.println("MENU");
                System.out.println("1. Register User");
                System.out.println("2. Book a Ticket");
                System.out.println("3. Show User Bookings");
                System.out.println("4. Show Tickets per Movie");
                System.out.println("5. Cancel Ticket");
                System.out.println("6. Exit the program");

        }
        
}


