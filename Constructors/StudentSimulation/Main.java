package LearningOOP.Constructors.StudentSimulation;
//import java.util.Scanner;
public class Main {
    
    public static void main( String [] Args)
    {
        //Scanner in = new Scanner(System.in);
       // studentData p = new studentData("Mark Jenel", "Cortas", "BSIT", "4", 2, 93.f, 99.5f);

       // p.introduceSelf();
        //p.evaluateGrade();

        //User u = new User(4343, "ssad", "shdjs", "jsdfbas");
        //u.userName
           // this cannot be used since the variable is private to the user class
       // u.setUserID(32443);
       // int id = u.getUserID(); //using setters and getters to initialize and return variable value
        // without accessing it, makes the data more secure
        
        //System.out.println(id);

        Employee e = new Employee("Mark Jenel","Cortas", "Secretary", "New York", "M", 19);
        Employee e1 = new Employee("Mark", "Cortas", "Secs");

        System.out.println(e1.getFirstName());
        System.out.println(e.getFirstName());
        System.out.println(e1.getAge());
        System.out.println(e1.getTitle());
    }

    
}
