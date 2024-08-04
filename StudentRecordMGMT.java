import java.util.Scanner;

class Student{
    private int studentID;
    private String name;
    private int age;
    private String department;
    
    public int getStudentID() {
        return studentID;
    }
    
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
     public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    public String toString()
    {
        return "Student ID: " + studentID + "\nName: " + name + "\nAge: " + age + "\nDepartment: " + department;
    }
}
class StudentRecordSystem 
{
    private Student[] std;
    private int count=0;

    public StudentRecordSystem(int size)
    {
        std = new Student[size];
    }
    public void addStudent(Student x)
    {
        if(count<std.length)
        {
            std[count]=x;
            count++;
        }
        else
        {
            System.out.println("error");
        }
    }
    public Student getStudent(int id)
    {
       for(int i=0;i<count;i++)
       {
        if(std[i].getStudentID()==id)
        {
            return std[i];
        }
       }
       return null;
    }
    public void displayAll()
    {
        for(int i=0;i<count;i++)
        {
            System.out.println(std[i]);
        }
    }
    
    

}
public class StudentRecordMGMT{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        StudentRecordSystem objs = new StudentRecordSystem(50);

        while (true) {
            System.out.println("1) add student");
            System.out.println("2) get student");
            System.out.println("3) display all");
            System.out.println("4) exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                {   
                    Student x= new Student();
                    System.out.println("Enter student id");
                    x.setStudentID(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter student name");
                    x.setName(sc.nextLine());
                    System.out.println("Enter student age");
                    x.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter department");
                    x.setDepartment(sc.nextLine());
                    objs.addStudent(x);
                    break;

                }
                case 2:
                {
                    System.out.println("Enter student id");
                    int id = sc.nextInt();
                    Student student = objs.getStudent(id);
                    if (student != null) 
                    {
                        System.out.println(student);
                    } else 
                    {
                        System.out.println("student not found");
                    }
                    break;
                }
                case 3: 
                {
                    objs.displayAll();
                    break;
                }
                case 4:
                {
                    System.exit(0);
                }
                default:
                    System.out.println("invalid choice");
        }
    }
}
}