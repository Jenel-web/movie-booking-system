package LearningOOP.MovieTickets;

import java.util.*;
// testing commit
public class Main {

    public static void main(String[] args) {
        
        int action;
        Scanner in = new Scanner (System.in);

        Cinema cinema = new Cinema();

        Movie m1 = new Movie("La La Land", "Mall of Asia");
        Movie m2 = new Movie("Hello, Love, Goodbye", "Megamall");
        Movie m3 = new Movie("Mantis", "Korean Theater");

        User u1 = new User("Jenel", "Pogi");
        User u2 = new User("Karen", "En");
        User u3 = new User("Michael", "Mike");

        Admin admin = new Admin();

        cinema.addMovie(m1);
        cinema.addMovie(m2);
        cinema.addMovie(m3);

        cinema.registerUser(u1);
        cinema.registerUser(u2);
        cinema.registerUser(u3);

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
                        cinema.registerUser(u);
                        break;
                    case 2: 
                        System.out.println("==================================================");
                        System.out.println("Booking a Ticket");

                        User booker;
                        //String Name;
                        innerLoop:
                        while (true) 
                        {   
                            System.out.print("Enter name of the user : ");
                            name = in.nextLine();

                            System.out.println("Finding the user....\n");

                            if(cinema.findUser(name) > -1 && cinema.findUser(name) < cinema.getUsers().size())
                            {
                                System.out.println("User found!");
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
                            cinema.showMovies();
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
                            cinema.generateTicket(booker, choice, seatCategory);
                            break innerLoop1;
                        }
                        break;
                    case 3:
                        System.out.println("==================================================");

                        System.out.println("Show User Bookings");
                        System.out.println("What is the name of the user? ");
                        String findName = in.nextLine();

                        if(cinema.findUser(findName) > -1)
                        {
                            cinema.showUserBookings(findName);
                        }
                        else
                        {
                            System.out.println("User has no booked tickets.");
                        }
                        
                        break;
                    case 4: 
                        System.out.println("==================================================");

                        System.out.println("Show Tickets in a Movie.");
                        int iteration = 1; // iterate on the movies
                        for(Movie m: cinema.getMovies())
                        {
                            System.out.println(iteration + ". " + m);
                            iteration++;
                        }
                        iteration = 1;
                        System.out.println();

                        int index;
                        showMoviesLoop:
                        while(true)
                        {
                            try
                            {
                                System.out.println("Which movie tickets would you like to see?");
                                index = in.nextInt();
                                in.nextLine();
                                //index--;   
                            } catch(InputMismatchException e)
                            {
                                System.out.println("Only Input integers within the range. Try again.");
                                in.nextLine();
                                continue showMoviesLoop;
                            }
                            if(index < 0 || index > cinema.getMovies().size())
                            {
                                System.out.println("Only Input integers within the range. Try again.");
                                continue showMoviesLoop;
                            }
                            System.out.println("These are the tickets for the movie : " + cinema.validateMovieIteration(index));
                            cinema.showTicketsInMovie(index);
                            break showMoviesLoop;
                        }
                        break;
                    case 5:
                        System.out.println("==================================================");

                        System.out.println("Cancel a Ticket.");
                        System.out.println("Enter name of the user : ");
                        String cancelName = in.nextLine();
                        
                        System.out.println("Enter the Ticket ID : ");
                        String ID = in.nextLine();

                        cinema.cancelTicket(cancelName, ID);
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
                            cinema.addMovie(m);
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
                            cinema.showMovies();

                            System.out.println("Enter Index of Movie to remove: ");
                            int removeIndex = in.nextInt();
                            in.nextLine();
                            //removeIndex--;
                            cinema.removeMovieTickets(removeIndex);
                            cinema.removeMovie(removeIndex);
          
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
    
    in.close();
    }
}