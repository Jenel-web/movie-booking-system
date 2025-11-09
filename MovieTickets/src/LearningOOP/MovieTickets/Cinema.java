package LearningOOP.MovieTickets;

public class Cinema {

        public String validateSeat(char choice)
        {
                return (choice == 'y'? "VIP" : "Regular" );
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
                System.out.println("8. Exit the program. \n");

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


