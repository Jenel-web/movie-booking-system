package LearningOOP.myStudent;

public class Student {
    
    String name;
    int age, grade;

    public void setName(String wholeName)
    {
        name = wholeName;
    }
   
    public String getName()
    {
        return name;
    }

    public void setGrade(int mark)
    {
        grade = mark;
    }
    public int getGrade()
    {
        return grade;
    }

    public void setAge(int years)
    {
        age = years;
    }
    public int getAge()
    {
        return age;
    }
}
