package LearningOOP.Inheritance;

public class Person {
    
    String name, sex;
    int age;
    Person(String name, String sex, int age)
    {// making a constructor here that will not be easily accessible by the toddler class
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    void checkStatus()
    {
        System.out.println("Name : " + name);
        System.out.println("Sex : " + sex);
        System.out.println("age : " + age);

    }
}
