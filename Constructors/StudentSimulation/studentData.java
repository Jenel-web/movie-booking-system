package LearningOOP.Constructors.StudentSimulation;

public class studentData {
    String firstName, lastName, course, section;
    int year;
    float midtermGrade, finalGrade;

    studentData(String firstName, String lastName, String course, String section, int year, float midtermGrade, float finalGrade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.section = section;
        this.year = year;
        this.midtermGrade = midtermGrade;
        this.finalGrade = finalGrade;
    }

    void introduceSelf()
    {
        System.out.println("Hello, My name is " + firstName + " " + lastName);
        System.out.println("I am in from " + course + ", year " + year + " - " + section);
    }

    void evaluateGrade()
    {
        float average = (midtermGrade + finalGrade)/2;

        if(average > 100)
        {
            System.out.println("Invalid grade!");
        }
        else if (average > 98 && average <= 100)
        {
            System.out.println("With Highest Honors : " + average );
        }
        else if(average > 95 && average < 98)
        {
            System.out.println("With High Honors : " + average);
        }
        else if( average > 90 && average < 95)
        {
            System.out.println("With Honors : " + average);
        }
        else if(average > 75 && average < 90)
        {
            System.out.println("Passed : " + average);
        }
        else 
        {
            System.out.println("Failed : " + average);
        }
    }
}
