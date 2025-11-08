package LearningOOP.StudentRegistrationSimulation;

public class Student {
    
    //private fields
    private String firstName, lastName, course, section;
    private int year;   

    Student(String firstName, String lastName, String course, int year, String section)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.year = year;
        this.section = section;


    }

    // setters

    /* 
    void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    void setCourse(String course)
    {
        this.course = course;
    }
    void setSection(String section)
    {
        this.section = section;
    }
    void setYear(int year)
    {
        this.year = year;
    } */

    // getters
    String getFirstName()
    {
        return firstName;
    }
     String getLastName()
    {
        return lastName;
    }
    String getCourse()
    {
        return course;
    }
     String getSection()
    {
        return section;
    }
    int getYear()
    {
        return year;
    }

}
