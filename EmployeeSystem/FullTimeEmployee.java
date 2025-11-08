package LearningOOP.EmployeeSystem;

public class FullTimeEmployee extends Employee {

    float monthlySalary;
    
    FullTimeEmployee(String name, String id, float salary)
    {
        super(name, id, salary);
        
    }

    public float calculateSalary()
    {
        return getSalary();
    }

    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Salary : " + calculateSalary());
        System.out.println();
    }


}
