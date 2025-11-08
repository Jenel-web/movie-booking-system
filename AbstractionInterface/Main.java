package LearningOOP.AbstractionInterface;

public class Main {
    
    public static void main(String[] args) {
        
        Cat c =  new Cat(); // do not instantiate using parent class if not inheritance because it will now be able to use its unique attributes
        Bird b = new Bird();

        b.walk();
        b.fly();
        b.makeSound();

        c.makeSound();
        c.walk();
        
    }
}
