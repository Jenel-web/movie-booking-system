package LearningOOP.AbstractionInterface;

public class Cat implements Animal, LandAnimal { // can implement another interface by using comma
    // can implement more than one class
    // useful because every method is forced.
    
    public void makeSound() // since the animal class is public, the methods used for this class must also be public.
    {
        System.out.println("Meow!");
    }

    public void walk()
    {
        System.out.println("Walking!");
    }
}
