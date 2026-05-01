package StudentManagementSystem.service;

import model.Student;
import util.CustomException;

import java.util.ArrayList;
import java.util.List;

public class StudentManager implements StudentService {
    
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully: " + student.getId());
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudentById(String id) throws CustomException {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        // Exception Handling
        throw new CustomException("Student with ID '" + id + "' not found.");
    }

    @Override
    public void updateStudent(String id, String newName, double newMarks) throws CustomException {
        Student student = getStudentById(id);
        student.setName(newName);
        student.setMarks(newMarks);
        System.out.println("Student information updated successfully.");
    }

    @Override
    public void deleteStudent(String id) throws CustomException {
        Student student = getStudentById(id);
        students.remove(student);
        System.out.println("Student record deleted successfully.");
    }

    @Override
    public void displayStudentPerformance(String id) throws CustomException {
        Student student = getStudentById(id);
        student.displayPerformance();
    }
}
