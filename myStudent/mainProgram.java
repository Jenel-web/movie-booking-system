package LearningOOP.myStudent;

public class mainProgram {
    
    public static void main(String [] Args)
    {
        String Name;
        int Age, Grade;
        Student me = new Student();

        me.setName("Mark Jenel Cortas");
        me.setAge(19);
        me.setGrade(98);

        Name = me.getName();
        Age = me.getAge();
        Grade = me.getGrade();

        System.out.println("Name : " + Name);
        System.out.println("Age : " + Age);
        System.out.println("Grade : " + Grade);

    }
}
