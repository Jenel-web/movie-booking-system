package LearningOOP.Polymorphism;

public class StrongEnemy extends Enemy {
    
    StrongEnemy()
    {
        name = "Strong Enemy"; // make sure to always use constructors for initialization
        hp = 100;   
    }
    
    void dialog()
    {
        System.out.println(name + " : I am Strong Enemy");
    }
    
}
