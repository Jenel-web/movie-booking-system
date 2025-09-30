package LearningOOP.MovieTickets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner (System.in);

        Cinema cinema = new Cinema();

        Movie m1 = new Movie("La La Land", "Mall of Asia");
        Movie m2 = new Movie("Hello, Love, Goodbye", "Megamall");
        Movie m3 = new Movie("Mantis", "Korean Theater");

        cinema.addMovie(m1);
        cinema.addMovie(m2);
        cinema.addMovie(m3);

        System.out.print("How many users are using this site? ");
        int n = in.nextInt();
        in.nextLine();

        for(int i = 0; i < n;i++)
        {
            System.out.print("Name : ");
            String name = in.nextLine();

            System.out.print("Username : ");
            String userName = in.nextLine();
        
            User u = new User(name, userName);
            cinema.registerUser(u);
        }
        
        
        outerLoop:

        while(true)
        {
            System.out.println("Ready to book a ticket?");
            
            User booker;
            String name;
            innerLoop:
            while(true) 
            {
                System.out.print("Enter name of the user : ");
                name = in.nextLine();

                System.out.print("Finding the user....");

                if(cinema.findUser(name) > -1 && cinema.findUser(name) < cinema.getUsers().size())
                {
                    booker = cinema.getUsers().get(cinema.findUser(name));
                    break innerLoop;
                }
                else
                {
                    System.out.println("User not found.");
                    continue innerLoop;
                }
            }
            innerLoop1:
            while(true)
            {

                int index = 1;
                for(Movie m: cinema.getMovies())
                {
                    System.out.println(index + ". " + m);
                    index++;
                }
                index = 1;
                int movieIndex;
                try{
                System.out.println("Enter the index of the Movie you want to watch : ");
                movieIndex = in.nextInt();
                in.nextLine();

                movieIndex-=1;
                }catch(InputMismatchException e)
                {
                    System.out.println("Only Input Integers.Try again.");
                    in.nextLine();
                    continue innerLoop1;
                }
                if(movieIndex < -1 || movieIndex >= cinema.getMovies().size())
                {
                    System.out.println("Index of the movie out of bounds.Enter index again.");
                    continue innerLoop1;
                }
                Movie choice = cinema.getMovies().get(movieIndex);
                System.out.println("You selected : " + choice);

                System.out.println("Do you want a VIP seat? (y/n)");
                char seat = in.nextLine().charAt(0);

                String seatCategory = cinema.validateSeat(seat);
                
                //ticket booking
                Ticket ticket;
                cinema.bookSeat(choice, seatCategory);
                ticket = new Ticket(booker, choice, seatCategory);
                cinema.bookTicket(ticket);
                break innerLoop1;
            }
            
            System.out.println("Do you want to book another ticket?Press y if you want to.");
            char repeat = in.nextLine().charAt(0);

            if(repeat == 'y')
            {
                continue outerLoop;
            }
            else
            {
                break outerLoop;
            }

        }
        System.out.println("Thank you for booking with us.");
    
        in.close();
    }
}
