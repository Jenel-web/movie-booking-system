package LearningOOP.Abstraction;

public class Dog extends Animal{

    void makeSound() // forced to override the abstract function
    {
        System.out.println("Arf! Arf!");
    }
   
}
