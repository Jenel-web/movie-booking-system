package LearningOOP.Practice.PetSounds;

public class  Cat extends Pet {
    
    private String color;

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }
    void makeSound()
    {
        System.out.println("Meow! Meow!");
    }

    void displayInfo()
    {
        super.displayInfo();
        System.out.println("Color : " + color);
    }
}
