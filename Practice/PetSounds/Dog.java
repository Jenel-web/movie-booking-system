package LearningOOP.Practice.PetSounds;

public class Dog extends Pet {
    
    private String breed;

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public String getBreed()
    {
        return breed;
    }
    void makeSound()
    {
        System.out.println("Arf! Arf!");
    }

    void displayInfo()
    {
        super.displayInfo();
        System.out.println("Breed : " + breed);

    }
}
