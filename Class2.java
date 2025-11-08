package LearningOOP;

// remember to keep the files in the same package to be able to reference both of them
// this is a lesson about encapsulation, wherein the data is hidden so taht it will not be easily accessed and changed
// by using the methods, setter and getter


public class Class2 {
    
    String lname, fname,job;
    int age;
    public void setLastName(String last) 
    {
        lname = last;
    }

    public String getLastName()
    {
        return lname;
    }

    public void setFirstName(String first)
    {
        fname = first;
    }

    public String getFirstName()
    {
        return fname;
    }

    public void setJob(String work)
    {
        job = work;
    }

    public String getJob()
    {
        return job;
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
