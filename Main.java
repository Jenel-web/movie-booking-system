package LearningOOP.MovieTickets;

import java.util.*;

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
                System.out.println("What do you want to do in this site? ");
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
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
            }
        }
    }
}