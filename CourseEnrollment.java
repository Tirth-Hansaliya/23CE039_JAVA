import java.util.Scanner;

class Courses {
    private int courseID;
    private String courseName;
    private int credit;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String toString() {
        return "Course ID: " + courseID + "\nCourse Name: " + courseName + "\nCredit: " + credit;
    }
}

class Enrollment {
    private int[][] studentCourse;
    private int[] count;

    public Enrollment(int numStudents, int numCourses) {
        studentCourse = new int[numStudents][numCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        if (count[studentID] < studentCourse[studentID].length) 
        {
            studentCourse[studentID][count[studentID]] = courseID;
            count[studentID]++;
            System.out.println("Student " + studentID + " enrolled in course " + courseID);
        } else 
        {
            System.out.println("Student " + studentID + " cannot enroll in more courses.");
        }
    }

    public void drop(int studentID, int courseID) 
    {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) 
        {
            if (studentCourse[studentID][i] == courseID) 
            {
                studentCourse[studentID][i] = studentCourse[studentID][count[studentID] - 1];
                count[studentID]--;
                found = true;
                System.out.println("Student " + studentID + " dropped course " + courseID);
                break;
            }
        }
        if (!found) 
        {
            System.out.println("Course " + courseID + " not found for student " + studentID);
        }
    }

    public void getEnrolmentCourse(int studentID, Courses[] courseCatalog) 
    {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) 
        {
            int courseID = studentCourse[studentID][i];
            for (Courses course : courseCatalog) 
            {
                if (course.getCourseID() == courseID) 
                {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}

public class CourseEnrollment {
    private static Courses[] courseCatalog;
    private static Enrollment Enrollment;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        courseCatalog = new Courses[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courseCatalog[i] = new Courses();
            System.out.print("Enter Course ID: ");
            courseCatalog[i].setCourseID(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Course Name: ");
            courseCatalog[i].setCourseName(sc.nextLine());
            System.out.print("Enter Course Credit: ");
            courseCatalog[i].setCredit(sc.nextInt());
        }

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        Enrollment = new Enrollment(numStudents, numCourses);

        while (true) {
            System.out.println("1. Enroll Student");
            System.out.println("2. Drop Course");
            System.out.println("3. Get Enrolled Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = sc.nextInt();
                    Enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseID = sc.nextInt();
                    Enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    Enrollment.getEnrolmentCourse(studentID, courseCatalog);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
