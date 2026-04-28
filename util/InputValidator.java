package StudentManagementSystem.util;

import java.util.Scanner;

public class InputValidator {

    public static String getValidString(Scanner scanner, String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: Input cannot be empty. Please try again.");
        }
    }

    public static double getValidMarks(Scanner scanner, String prompt) {
        double marks = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                marks = Double.parseDouble(input);
                if (marks >= 0 && marks <= 100) {
                    return marks;
                } else {
                    System.out.println("Error: Marks must be between 0 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a valid decimal number.");
            }
        }
    }
    
    public static int getValidInt(Scanner scanner, String prompt) {
        int val = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                val = Integer.parseInt(input);
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter a valid integer.");
            }
        }
    }
}
