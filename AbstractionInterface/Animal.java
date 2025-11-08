package LearningOOP.AbstractionInterface;

public interface Animal
{
    void makeSound(); // when declared in an interface class, they are automatically an abstract method.
    // anyone who implements from here will be forced to have the same function.
}