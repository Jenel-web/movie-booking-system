package LearningOOP.Practice;

public class PrintedBook extends Book{
    
    int numPages;

    PrintedBook(String title, String author, String yearPublished, int numPages)
    {
        super(title, author, yearPublished);
        this.numPages = numPages;
    }

    @Override
    void displayInfo() {
        // TODO Auto-generated method stub
        super.displayInfo();
        System.out.println("Number of Pages : " + numPages);
    }
}
