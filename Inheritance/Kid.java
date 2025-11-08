package LearningOOP.Inheritance;

public class Kid extends Toddler{
    
        int gradeLevel;
    Kid(String name, String sex, int age, String school, int gradeLevel)
    {
        super(name, sex, age, school);
        this.gradeLevel = gradeLevel;
    }

    @Override
    void checkStatus() {
    // TODO Auto-generated method stub
    super.checkStatus();
    System.out.println("Grade Level : " + gradeLevel); // new attribute of kid class
    }
}
