package LearningOOP.MovieTickets;

import java.util.UUID;  

public class Ticket {

    private User user;
    private Movie movie;
    private String seatCategory;
    private String TicketID;
    Ticket(User user, Movie movie, String seatCategory) // make the user enter again if the seat category is invalid.
    {
        this.user = user;
        this.movie = movie;
        this.seatCategory = seatCategory;
        this.TicketID = UUID.randomUUID().toString().substring(0,6);
    }

    public Movie getMovie() {
        return movie;
    }

    public User getUser() {
        return user;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public String getTicketID() {
        return TicketID;
    }

    public String toString()
    {   
        return "Name : " + user.getName() + " || Movie : " + movie.getTitle() + " || Seat : " + seatCategory.toUpperCase() + " || Ticket ID : " + TicketID;
    }
}
