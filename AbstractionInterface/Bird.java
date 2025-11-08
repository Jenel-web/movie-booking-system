package LearningOOP.AbstractionInterface;

public class Bird implements Animal, LandAnimal, AirAnimal {
    
    public void makeSound()
    {
        System.out.println("Chirpp!");
    }

    public void walk()
    {
        System.out.println("Walking!");
    }

    public void fly()
    {
        System.out.println("Flying!");
    }
}
