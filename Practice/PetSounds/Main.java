package LearningOOP.Practice.PetSounds;
import java.util.ArrayList; // arraylist has its own thing we should call before using it.
public class Main {
    
   public static void main(String[] args) 
   {
        ArrayList <Pet> pets = new ArrayList<>();
       
        Dog d = new Dog();
        Cat c = new Cat();
        Cat c1 = new Cat();

        pets.add(d);
        pets.add(c);
        pets.add(c1);

        d.setAge(12);
        d.setName("Brando");
        d.setBreed("Golden Retriever");

        c.setName("Potchi");
        c.setAge(4);
        c.setColor("Gray and White");

        c1.setName("Cat Cat");
        c1.setAge(5);
        c1.setColor("Lots of Colors");

        for (Pet pet : pets)
        {
            pet.displayInfo();
            pet.makeSound();
            System.out.println("--------------------------------------------");

        }   
    }
}