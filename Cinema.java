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
                                System.out.println("There are no VIP seats left.");
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
        
}


