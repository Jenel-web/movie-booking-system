package LearningOOP.Practice;

public class Ebook extends Book{

    int fileSize;

    Ebook(String title, String author, String yearPublished, int fileSize)
    {
        super(title, author, yearPublished);
        this.fileSize = fileSize;
    }

    @Override
    void displayInfo() {
        // TODO Auto-generated method stub
        super.displayInfo();
        System.out.println("File Size (MB) : " + fileSize);
    }
}
