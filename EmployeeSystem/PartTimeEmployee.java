package LearningOOP.EmployeeSystem;

public class PartTimeEmployee extends Employee{

    int hoursWorked;
    float hourlySalary;
    float salary;

    PartTimeEmployee(String name, String id, float hourlySalary, int hoursWorked)
    {
        super(name,id, hourlySalary * hoursWorked);
        this.hoursWorked = hoursWorked;
        this.hourlySalary = hourlySalary;
        }
    public float calculateSalary()
    {
        salary =  hourlySalary * hoursWorked;

        return salary;
    }

    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("Salary :  "+ salary);
        System.out.println();
    }
}
