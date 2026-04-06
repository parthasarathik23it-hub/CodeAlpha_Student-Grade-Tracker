import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker (Code Alpha Internship)!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a student's grade");
            System.out.println("2. Display summary report");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (1-3).");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter student's name: ");
                String name = scanner.nextLine();
                
                System.out.print("Enter student's grade: ");
                double grade = -1;
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade < 0) {
                        System.out.println("Grade cannot be negative. Please try again.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid grade format. Please enter a valid number.");
                    continue;
                }
                
                students.add(name);
                grades.add(grade);
                System.out.println("Grade added successfully.");
                
            } else if (choice == 2) {
                if (grades.isEmpty()) {
                    System.out.println("\nNo grades have been entered yet.");
                } else {
                    displaySummary(students, grades);
                }
            } else if (choice == 3) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
        
        scanner.close();
    }

    private static void displaySummary(ArrayList<String> students, ArrayList<Double> grades) {
        double sum = 0;
        double highest = grades.get(0);
        double lowest = grades.get(0);
        int highestIndex = 0;
        int lowestIndex = 0;

        System.out.println("\n==================================");
        System.out.println("          SUMMARY REPORT          ");
        System.out.println("==================================");
        System.out.println(String.format("%-20s | %s", "Student Name", "Grade"));
        System.out.println("----------------------------------");
        
        for (int i = 0; i < grades.size(); i++) {
            double currentGrade = grades.get(i);
            System.out.println(String.format("%-20s | %.2f", students.get(i), currentGrade));
            sum += currentGrade;
            
            if (currentGrade > highest) {
                highest = currentGrade;
                highestIndex = i;
            }
            if (currentGrade < lowest) {
                lowest = currentGrade;
                lowestIndex = i;
            }
        }

        double average = sum / grades.size();
        System.out.println("----------------------------------");
        System.out.printf("Total Students: %d\n", grades.size());
        System.out.printf("Class Average:  %.2f\n", average);
        System.out.printf("Highest Score:  %.2f (by %s)\n", highest, students.get(highestIndex));
        System.out.printf("Lowest Score:   %.2f (by %s)\n", lowest, students.get(lowestIndex));
        System.out.println("==================================");
    }
}
