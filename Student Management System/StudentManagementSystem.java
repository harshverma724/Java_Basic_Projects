import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private ArrayList<Student> students;

    // Student class
    static class Student {
        private String name;
        private int age;
        private double grade;

        // Constructor
        public Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getGrade() {
            return grade;
        }

        // Display student information
        public void displayStudentInfo() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Grade: " + grade);
        }
    }

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Method to add a new student
    public void addStudent(String name, int age, double grade) {
        Student newStudent = new Student(name, age, grade);
        students.add(newStudent);
        System.out.println("Student added successfully.");
    }

    // Method to view all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                student.displayStudentInfo();
                System.out.println("-----------------------------------");
            }
        }
    }

    // Method to delete a student by name
    public void deleteStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                students.remove(student);
                System.out.println("Student " + name + " has been removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Delete Student");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            system.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    system.addStudent(name, age, grade);
                    break;

                case 2: // View Students
                    system.viewStudents();
                    break;

                case 3: // Delete Student
                    System.out.print("Enter the name of the student to delete: ");
                    String deleteName = scanner.nextLine();
                    system.deleteStudent(deleteName);
                    break;

                case 4: // Exit
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
