package LearningOOP.Enums;

public enum CoffeeSize {
   
    SMALL(50, "Small"), MEDIUM(70, "Medium"), LARGE(90, "Large");

    int price;
    String size;

    CoffeeSize(int price, String size)
    {
        this.price = price;
        this.size = size;
    }
}
