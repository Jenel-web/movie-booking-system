package LearningOOP.Inheritance;

public class Main {
   
    public static void main(String[] args) 
    {
        Person p = new Person("Jenel", "Male", 19);
        Toddler t = new Toddler("Rora", "Female", 17, "PUP");
        Kid k = new Kid("Joseph", "Male",20,  "PUP", 14);
        // since a constructor is made, the initialization should contain arguments.

       // p.name = "Jenel";
        //p.sex = "Male";
        //p.age = 19;

        //t.age = 19;
       // t.name = "jobnr";
        //t.sex = "Female";

        p.checkStatus();
        t.checkStatus(); // I am now able to print the school in this method because i override the method from the superclass
        // and added functionalities in it.
        t.drink();
        System.out.println(t.school); // this is an extra attribute of the child class
        k.checkStatus();
    }
    

}
