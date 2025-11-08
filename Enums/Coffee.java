package LearningOOP.Enums;

public class Coffee {
    

    private String name;
    private CoffeeSize size;

    Coffee(String name, CoffeeSize size)
    {
        this.name = name;
        this.size = size;
    }

    String getName()
    {
        return name;
    }

    CoffeeSize getSize()
    {
        return size;
    }

}
