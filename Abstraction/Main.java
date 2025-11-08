package LearningOOP.Abstraction;

public class Main {
    
    public static void main(String[] args) {

    //this is just an abstract idea, should be hidden

    // this cannot be instantiated because it is an abstract class
    //Animal a = new Animal();
    // useless since there is no such thing as a new animal
    
    // this is more concrete and specific
    Animal c = new Cat();
    Animal d = new Dog();

    c.makeSound(); 
    d.makeSound();
    }
    }

