package LearningOOP.Constructors;

public class student {
    String name;
    int age;
    float grade;

    student(String name, int age, float grade)
    {
        this.name = name;
        this.age = age;
        this.grade = grade;
        
        System.out.println("\nStudent " + name + " Created");
    }

    void introduce()
    {
        System.out.println("My name is " + name);
    }
    void sayAge()
    {
        System.out.println("I am " + age + " years old!");
    }
    void talkTo(student c) // we can also pass class names as arguments so we are able to 
    // call the attributes of that class
    {
        System.out.println(name + ": Hello " + c.name);
    }
}
