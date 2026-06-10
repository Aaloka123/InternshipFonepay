package studentmanagementsystem.view;

import studentmanagementsystem.controller.StudentController;
import studentmanagementsystem.model.StudentModel;

import java.util.List;
import java.util.Scanner;

// Handles ALL user input/output (UI layer)
public class MenuHandler {

    private StudentController controller;
    private Scanner sc;

    public MenuHandler(StudentController controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    // START APPLICATION
    public void start() {

        while (true) {

            showMenu();

            int choice = sc.nextInt();

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
                    deleteStudent();
                    break;

                case 5:
                    updateStudent();
                    break;

                case 6:
                    sortStudents();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // SHOW MENU
    private void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student");
        System.out.println("6. Sort Students");
        System.out.println("7. Exit");
        System.out.print("Enter choice: ");
    }

    // ADD STUDENT
    private void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        controller.addStudent(id, name, age, grade);
    }

    // VIEW ALL STUDENTS
    private void viewAllStudents() {
        display(controller.getAllStudents());
    }

    // SEARCH
    private void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.println(controller.searchStudent(id));
    }

    // DELETE
    private void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        controller.deleteStudent(id);
    }

    // UPDATE
    private void updateStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        controller.updateStudent(id, name, age, grade);
    }

    // SORT FEATURE
    private void sortStudents() {

        System.out.println("\nSort By:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        List<StudentModel> sortedList;

        switch (choice) {

            case 1:
                sortedList = controller.sortById();
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        display(sortedList);
    }

    // DISPLAY TABLE FORMAT (IMPROVED)
    private void display(List<StudentModel> students) {

        // Increased column widths
        int idW = 8;
        int nameW = 20;
        int ageW = 5;
        int gradeW = 8;

        System.out.println("\n+----------+----------------------+-----+--------+");

        System.out.printf("| %-8s | %-20s | %-3s | %-6s |\n",
                "ID", "Name", "Age", "Grade");

        System.out.println("+----------+----------------------+-----+--------+");

        if (students == null || students.isEmpty()) {
            System.out.printf("| %-45s |\n", "No students found");
            System.out.println("+----------+----------------------+-----+--------+");
            return;
        }

        for (StudentModel s : students) {
            System.out.printf("| %-8d | %-20s | %-3d | %-6s |\n",
                    s.getId(),
                    s.getName(),
                    s.getAge(),
                    s.getGrade());
        }

        System.out.println("+----------+----------------------+-----+--------+");
    }
}