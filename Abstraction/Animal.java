package LearningOOP.Abstraction;

abstract class Animal {
    // making it abstract will make it uninstatiatable because it will be like the general class

    abstract void makeSound(); // can only make abstract methods if the class is abstract.
    // this will force the child classes to override this method
    // abstract methods dont have body.

    // can still make methods that are not abstract here.
}
