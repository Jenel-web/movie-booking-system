package LearningOOP.Practice;

public class Main {
    
    public static void main(String[] args) {
         
        Book b = new Ebook("Biography", "Mark Jenel Cortas", "2003" , 23);
        Book pb = new PrintedBook("Auto Biography", "Cortas Jenel", "2023", 406);


        b.displayInfo();
        pb.displayInfo();
    }
}
