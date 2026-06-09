package studentmanagementsystem;

import studentmanagementsystem.controller.StudentController;
import studentmanagementsystem.repository.StudentRepository;
import studentmanagementsystem.services.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // STEP 1: Create repository (ONLY ONE)
        StudentRepository repository = new StudentRepository();

        // STEP 2: Pass repository to service
        StudentService service = new StudentService(repository);

        //  STEP 3: Pass service to controller
        StudentController controller = new StudentController(service);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
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
                    break;

                case 2:
                    controller.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();
                    controller.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    controller.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Grade: ");
                    String newGrade = sc.nextLine();

                    controller.updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}