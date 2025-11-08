package LearningOOP.Inheritance;

public class Toddler extends Person{ // this keyword helps this class to
    // be able to access methods that are from the person class
    //because the person class is now the parent class of this toddler
    String school; // should initialize the variable first to be accessed by the "this" function
    Toddler(String name, String sex, int age, String school) // the constructor also has to have the arguments like whats in the parent class.
    {
        super(name, sex, age);
        this.school = school; // super means calling the parent class and then putting the arguments there
    } // this will make it possible to declare the values of the object that when initializing the object.
    // this way of doing will help us give the child class to have more attributes than the parent class.

    void drink()
    {
        System.out.println("Drinking milk!");
    }

    void checkStatus()
    {
        super.checkStatus();// this is how you override the methods made by the parent class
        // to be able to do more actions on the child class.

        System.out.println("School : " + school);
    }
    
}
