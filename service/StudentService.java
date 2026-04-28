package StudentManagementSystem.service;

import model.Student;
import util.CustomException;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(String id) throws CustomException;
    void updateStudent(String id, String newName, double newMarks) throws CustomException;
    void deleteStudent(String id) throws CustomException;
    void displayStudentPerformance(String id) throws CustomException;
}
