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
                    reverseStudents();
                    break;

                case 8:
                    shuffleStudents();
                    break;

                case 9:
                    showYoungestStudent();
                    break;

                case 10:
                    showOldestStudent();
                    break;

                case 11:
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
        System.out.println("7. Reverse Students List");
        System.out.println("8. Shuffle Students");
        System.out.println("9. Show Youngest Student");
        System.out.println("10. Show Oldest Student");
        System.out.println("11. Exit");
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

    // SEARCH STUDENT
    private void searchStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.println(controller.searchStudent(id));
    }

    // DELETE STUDENT
    private void deleteStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        controller.deleteStudent(id);
    }

    // UPDATE STUDENT
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

            case 2:
                sortedList = controller.sortByName();
                break;

            case 3:
                sortedList = controller.sortByAge();
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        display(sortedList);
    }

    // REVERSE STUDENT LIST
    private void reverseStudents() {
        List<StudentModel> reversedList = controller.reverseStudents();
        display(reversedList);
    }

    // SHUFFLE STUDENTS
    private void shuffleStudents() {
        List<StudentModel> shuffledList = controller.shuffleStudents();
        display(shuffledList);
    }

    // SHOW YOUNGEST STUDENT
    private void showYoungestStudent() {

        StudentModel youngest = controller.getYoungestStudent();

        System.out.println("\nYoungest Student:");
        System.out.println("+----------+----------------------+-----+--------+");
        System.out.printf("| %-8s | %-20s | %-3s | %-6s |\n",
                "ID", "Name", "Age", "Grade");
        System.out.println("+----------+----------------------+-----+--------+");

        System.out.printf("| %-8d | %-20s | %-3d | %-6s |\n",
                youngest.getId(),
                youngest.getName(),
                youngest.getAge(),
                youngest.getGrade());

        System.out.println("+----------+----------------------+-----+--------+");
    }

    // SHOW OLDEST STUDENT
    private void showOldestStudent() {

        StudentModel oldest = controller.getOldestStudent();

        System.out.println("\nOldest Student:");
        System.out.println("+----------+----------------------+-----+--------+");
        System.out.printf("| %-8s | %-20s | %-3s | %-6s |\n",
                "ID", "Name", "Age", "Grade");
        System.out.println("+----------+----------------------+-----+--------+");

        System.out.printf("| %-8d | %-20s | %-3d | %-6s |\n",
                oldest.getId(),
                oldest.getName(),
                oldest.getAge(),
                oldest.getGrade());

        System.out.println("+----------+----------------------+-----+--------+");
    }

    // DISPLAY TABLE FORMAT
    private void display(List<StudentModel> students) {

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