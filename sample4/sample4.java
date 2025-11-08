package LearningOOP.sample4;

public class sample4 {
    int emp_id,emp_age;
    String emp_dept;
 
sample4(int id_no,int age,String dept)//accepts 3 arguments
 { emp_id = id_no;
 emp_age = age;
 emp_dept = dept;
 }
 public int getId()
 { return emp_id;}
 public int getAge()
 { return emp_age;}
 public String getDept()
 { return emp_dept;}
}
