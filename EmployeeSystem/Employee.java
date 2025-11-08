package LearningOOP.EmployeeSystem;

abstract class Employee {
    
    private String name, id;
    private float salary;

    Employee(String name, String id, float salary)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public float getSalary()
    {
        return salary;
    }

    abstract float calculateSalary();
    public void displayInfo()
    {
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
    }


}
