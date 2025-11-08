package LearningOOP.Enums;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        //Coffee coffee = new Coffee(null, null)

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = in.nextLine();

        System.out.println("What Coffee Size do you want? (small, medium, large) ");
        String input = in.nextLine().toUpperCase();

        CoffeeSize coffee = CoffeeSize.valueOf(input);

        Coffee order = new Coffee(name, coffee);
        
        System.out.println("\nName : " + name);
        System.out.println("Order : " + coffee.size);
        System.out.println("Price : " + coffee.price);
        System.out.println("Size : " + order.getSize());
        System.out.println("Name : " + order.getName());
        
        in.close();
        }
}
