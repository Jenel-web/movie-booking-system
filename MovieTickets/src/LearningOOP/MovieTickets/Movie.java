package LearningOOP.MovieTickets;

public class Movie 
{   
    
    private String title, theater, seatCategory;
    private int availableVipSeats, availableRegularSeats;

    Movie(String title, String theater)
    {
        this.title = title;
        this.theater = theater;
        availableRegularSeats = 10;
        availableVipSeats = 5;
    }

    public String getSeatCategory() {
        return seatCategory;
    }

    public String getTheater() {
        return theater;
    }

    public String getTitle() {
        return title;
    }

  
   public String toString()
   {
        return "Title : " + title + " || Location : " + theater + " || VIP Seats Available : " + availableVipSeats + " || Regular Seats Available : " + availableRegularSeats;
   }

}   