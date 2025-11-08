package LearningOOP.Polymorphism;

public class Enemy {
    
    String name;
    int hp;
    void dialog()
    {
        System.out.println("Please override me."); // make a comment like this as a reminder for overriding 
    }

    void checkStatus()
    {
        System.out.println("Name : " + name);
        System.out.println("HP : " + hp);
    }
}
