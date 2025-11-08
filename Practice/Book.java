package LearningOOP.Practice;

public class Book {
    
    String title, author, yearPublished;

    Book(String title, String author, String yearPublished)
    {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    
    
    void displayInfo()
    {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Year Published : " + yearPublished);
    }
}
