package LearningOOP.Abstraction;

public class Cat extends Animal {
    
    void makeSound() // forced to override the abstract function
    {
        System.out.println("Meow! Meow!");
    }
}
