package LearningOOP.Constructors.StudentSimulation;

public class Employee {
    
    private String firstName, lastName, title, address, sex;
    private int age;

    Employee(String firstName, 
             String lastName, 
             String title, 
             String address, 
             String sex, 
             int age)
             {
                this.firstName = firstName;
                this.lastName = lastName;
                this.title = title;
                this.address = address;
                this.sex = sex;
                this.age = age;
             }
    Employee(String firstName, String lastName, String title)
    {
                this.firstName = firstName;
                this.lastName = lastName;
                this.title = title;
                address = "N/A";
                sex = "N/A";
                age = 0;

                // overloading constructors will help us in databases, because there are times
                // that people might not enter data on their profile because thay dont know what to put, so 
                // doing these will help it have a placeholder.
                
    }
    Employee()
    {
                 firstName = "N/A";
                 lastName = "N/A";
                 title = "N/A";
                 address = "N/A";
                 sex = "N/A";
                 age = 0;
    }


    String getFirstName()
    {
        return firstName;
    }

    String getLastName()
    {
        return lastName;
    }

    String getTitle()
    {
        return title;
    }

    String getAddress()
    {
        return address;
    }

    String getSex()
    {
        return sex;
    }
    
    int getAge()
    {
        return age;
    }

}


