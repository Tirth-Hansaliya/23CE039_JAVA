
import java.util.Scanner;

class Student {
    private int Studentid;
    private String Name;

    public int getStudentId() {
        return Studentid;
    }

    public void setStudentId(int Studentid) {
        this.Studentid = Studentid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

class Grade {
    private int StudentId;
    private int courseid;
    private char Grade;

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public char getGrade() {
        return Grade;
    }

    public void setGrade(char grade) {
        Grade = grade;
    }
}

class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;

    public GradingSystem(int numStudents, int numCourses) 
    {
        students = new Student[numStudents];
        grades = new Grade[numStudents * numCourses];
        courseCredits = new int[numCourses];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student stud) 
    {
        if (studentCount < students.length) 
        {
            students[studentCount] = stud;
            studentCount++;
        } else {
            System.out.println("Cannot add more students.");
        }
    }

    public void addGrade(Grade grade) 
    {
        if (gradeCount < grades.length) 
        {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Cannot add more grades.");
        }
    }

    public void addCourseCredits(int courseId, int credit) 
    {
        if (courseId < courseCredits.length) {
            courseCredits[courseId] = credit;
        } else {
            System.out.println("InvalStudentid course StudentID.");
        }
    }

    public double calculateGPA(int StudentID) 
    {
        int totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) 
        {
            if (grades[i].getStudentId() == StudentID) 
            {
                int courseId = grades[i].getCourseid();
                int credit = courseCredits[courseId];
                totalPoints += gradeToPoints(grades[i].getGrade()) * credit;
                totalCredits += credit;
            }
        }

        if (totalCredits == 0 ) {
            return 0;
        }else{
            return (double) totalPoints / totalCredits;
        }

    }

    private int gradeToPoints(char grade) 
    {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
}

public class GradingSystemMGTM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradingSystem gs = new GradingSystem(100, 10); 

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student student = new Student();
                    System.out.print("Enter Student StudentID: ");
                    student.setStudentId(sc.nextInt());
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    student.setName(sc.nextLine());
                    gs.addStudent(student);
                    break;
                case 2:
                    Grade grade = new Grade();
                    System.out.print("Enter Student StudentID: ");
                    grade.setStudentId(sc.nextInt());
                    System.out.print("Enter Course StudentID: ");
                    grade.setCourseid(sc.nextInt());
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    grade.setGrade(sc.next().charAt(0));
                    gs.addGrade(grade);
                    break;
                case 3:
                    System.out.print("Enter Course StudentID: ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Course Credits: ");
                    int credits = sc.nextInt();
                    gs.addCourseCredits(courseId, credits);
                    break;
                case 4:
                    System.out.print("Enter Student StudentID: ");
                    int StudentID = sc.nextInt();
                    double gpa = gs.calculateGPA(StudentID);
                    System.out.println("GPA of student " + StudentID + " is: " + gpa);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("InvalStudentid choice. Please choose again.");
            }
        }
    }
}
