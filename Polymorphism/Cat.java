package LearningOOP.Polymorphism;

public class Cat extends Animal{

    @Override
    void makeSound() {
        System.out.println("Meow!"); //overrides the makeSound function and not printing what the animal class says
    }
}
