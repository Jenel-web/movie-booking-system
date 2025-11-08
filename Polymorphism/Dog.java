package LearningOOP.Polymorphism;

public class Dog extends Animal {
    
    @Override
    void makeSound() {
        System.out.println("Arf! Arf!"); // overrides the makeSound function and not printing what the animal class says
    }

}
