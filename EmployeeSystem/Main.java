package LearningOOP.EmployeeSystem;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int n;
        float salary;
        String name, id;

        ArrayList<Employee> employees = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.println("How many employees will you put in?");
        n = in.nextInt();
        in.nextLine();

        for(int i = 0; i < n; i++)
        {
            System.out.println("Is the employee part-time(1) or full time(2)?");
            int type = in.nextInt();
            in.nextLine();
    
            switch(type)
            {
                case 1:
                
                    System.out.println("Name : ");
                    name = in.nextLine();

                    System.out.println("Employee ID: ");
                    id = in.nextLine();
            
                    System.out.println("Hourly Rate : ");
                    float hourlySalary = in.nextFloat();

                    System.out.println("Hours Worked : ");
                    int hoursWorked = in.nextInt();
                    in.nextLine(); 

                    PartTimeEmployee partTime = new PartTimeEmployee(name, id, hourlySalary, hoursWorked); //should not be multiplied because
                    // the constructor is just initialization
                    
                    employees.add(partTime);
                    break;

                case 2: 

                    System.out.println("Name : ");
                    name = in.nextLine();

                    System.out.println("Employee ID: ");
                    id = in.nextLine();
                    
                    System.out.println("Monthly Salary : ");
                    salary = in.nextFloat();

                    FullTimeEmployee fullTime = new FullTimeEmployee(name, id, salary);

                    employees.add(fullTime);
                    break;
               
                default:
                    break;
            }
        }
        System.out.println("\nThe employees are :\n");
         for(Employee employee : employees)
            {
                employee.displayInfo();
            }

        in.close();
    }
}
