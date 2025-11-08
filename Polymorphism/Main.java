package LearningOOP.Polymorphism;

public class Main {
    
    public static void main(String[] args) {
        /* 
        Animal d = new Dog(); // can call the child classes using the name of the parent class
        Animal c = new Cat();
        
        d.makeSound();
        c.makeSound(); */

        Enemy se = new StrongEnemy();
        Enemy we = new weakEnemy();

        se.checkStatus();
        se.dialog();

        we.checkStatus();
        we.dialog();

    }
}
