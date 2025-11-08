package LearningOOP.Polymorphism;

public class weakEnemy extends Enemy{
    
    weakEnemy()
    {
        name = "Weak Enemy"; // constructors are used for initialization
        hp = 10;
        // because they are immmediately used when the class is called to make a new object.
    }

    void dialog()
    {
        System.out.println(name + " : I am weak enemy.");
    }
}
