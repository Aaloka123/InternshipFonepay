package studentmanagementsystem.view;

import studentmanagementsystem.controller.StudentController;

import java.util.Scanner;

public class MenuHandler {

    private StudentController controller;
    private Scanner sc;

    public MenuHandler(StudentController controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    public void start() {

        while (true) {

            showMenu();

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> addStudent();
                case 2 -> controller.showAllStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> updateStudent();
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // MENU DISPLAY ONLY
    private void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    // ADD STUDENT FLOW
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

    // SEARCH FLOW
    private void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        controller.searchStudent(id);
    }

    // DELETE FLOW
    private void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        controller.deleteStudent(id);
    }

    // UPDATE FLOW
    private void updateStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Grade: ");
        String grade = sc.nextLine();

        controller.updateStudent(id, name, age, grade);
    }
}