package LearningOOP.StudentRegistrationSimulation;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        
        System.out.println("How many Students will you input?");
        int n = in.nextInt();

        in.nextLine();

        Student students[] = new Student[n];
        
        //Input of Details
        for(int i = 0; i < n; i++)
        {
            System.out.print("First Name : ");
            String firstName = in.nextLine();

            System.out.print("Last Name : ");
            String lastName = in.nextLine();

            System.out.print("Year : ");
            int year = in.nextInt();
            in.nextLine();

            System.out.print("Course : ");
            String course = in.nextLine();

            System.out.print("Section : ");
            String section = in.nextLine();
            
            System.out.println();

            students[i] = new Student(firstName, lastName, course, year, section); // make a new object for student so that it can access the methods3
           
           
            /* 
            students[i].setFirstName(firstName);
            students[i].setLastName(lastName);
            students[i].setYear(year);
            students[i].setCourse(course);
            students[i].setSection(section);
            */
            
        }

        System.out.println("The following are the students of PUP: \n");
        for(Student s: students)
        {
            System.out.println("Name : " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Section : " + s.getCourse() + " " + s.getYear() + "-" + s.getSection());
            System.out.println();
        }

        in.close();
    }
}
