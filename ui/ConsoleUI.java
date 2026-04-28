package StudentManagementSystem.ui;

import model.RegularStudent;
import model.Student;
import service.StudentManager;
import service.StudentService;
import util.CustomException;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private StudentService studentService;
    private Scanner scanner;

    public ConsoleUI() {
        this.studentService = new StudentManager();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;

        System.out.println("==================================================");
        System.out.println("       Welcome to Student Management System       ");
        System.out.println("==================================================");

        while (!exit) {
            printMenu();
            int choice = InputValidator.getValidInt(scanner, "Enter your choice (1-7): ");

            try {
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        deleteStudent();
                        break;
                    case 6:
                        displayPerformance();
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select from 1 to 7.");
                }
            } catch (CustomException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("1. Add New Student Record");
        System.out.println("2. View All Student Details");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Information");
        System.out.println("5. Delete Student Record");
        System.out.println("6. Display Student Performance");
        System.out.println("7. Exit");
    }

    private void addStudent() {
        System.out.println("\n--- Add New Student ---");
        String id = InputValidator.getValidString(scanner, "Enter Student ID: ");
        
        try {
            studentService.getStudentById(id);
            System.out.println("Error: A student with ID '" + id + "' already exists.");
            return;
        } catch (CustomException e) {
            // Expected behavior, student does not exist, proceed.
        }

        String name = InputValidator.getValidString(scanner, "Enter Student Name: ");
        double marks = InputValidator.getValidMarks(scanner, "Enter Student Marks (0-100): ");

        studentService.addStudent(new RegularStudent(id, name, marks));
    }

    private void viewAllStudents() {
        System.out.println("\n--- All Student Details ---");
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void searchStudent() throws CustomException {
        System.out.println("\n--- Search Student ---");
        String id = InputValidator.getValidString(scanner, "Enter Student ID to search: ");
        Student student = studentService.getStudentById(id);
        System.out.println("Found Record: " + student);
    }

    private void updateStudent() throws CustomException {
        System.out.println("\n--- Update Student ---");
        String id = InputValidator.getValidString(scanner, "Enter Student ID to update: ");
        // Ensure student exists
        studentService.getStudentById(id);
        
        String newName = InputValidator.getValidString(scanner, "Enter New Name: ");
        double newMarks = InputValidator.getValidMarks(scanner, "Enter New Marks: ");
        
        studentService.updateStudent(id, newName, newMarks);
    }

    private void deleteStudent() throws CustomException {
        System.out.println("\n--- Delete Student ---");
        String id = InputValidator.getValidString(scanner, "Enter Student ID to delete: ");
        studentService.deleteStudent(id);
    }

    private void displayPerformance() throws CustomException {
        System.out.println("\n--- Student Performance ---");
        String id = InputValidator.getValidString(scanner, "Enter Student ID: ");
        studentService.displayStudentPerformance(id);
    }
}
