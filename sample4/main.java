package LearningOOP.sample4;

public class main {
    public static void main  (String[] args)
 {
 sample4 employee1 = new sample4(1234,25,"Payroll");
 System.out.println("Employee ID : " + employee1.getId());
 System.out.println("Age : "+ employee1.getAge());
 System.out.println("Department : " + employee1.getDept()+"\n");
 sample4 employee2 = new sample4(5678,30,"Human Resources");
 System.out.println("Employee ID : " + employee2.getId());
 System.out.println("Age : "+ employee2.getAge());
 System.out.println("Department : " + employee2.getDept());
 }
}
