package LearningOOP;

public class mainProgram {
    public static void main (String []Args)
    {
        String work, first, last;
        int years;
        Class2 person = new Class2();
        
        person.setAge(19);
        person.setFirstName("Mark Jenel");
        person.setLastName("Cortas");
        person.setJob("Student");

        work = person.getJob(); // these are just methods so remember to call the reference
        first = person.getFirstName();
        last = person.getLastName();
        years = person.getAge();

        System.out.println("Name : " + first + " " + last);
        System.out.println("Age : " + years);
        System.out.println("Job : " + work);
    }
}
