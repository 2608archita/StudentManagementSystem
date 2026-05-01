package StudentManagementSystem.model;

public class RegularStudent extends Student {

    public RegularStudent(String id, String name, double marks) {
        super(id, name, marks);
    }

    @Override
    public void displayPerformance() {
        String grade;
        if (marks >= 90) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "B";
        } else if (marks >= 70) {
            grade = "C";
        } else if (marks >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Student " + name + " (" + id + ") Performance:");
        System.out.println("Overall Marks: " + marks);
        System.out.println("Calculated Grade: " + grade);
    }
}
