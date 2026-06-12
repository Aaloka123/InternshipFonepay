package studentmanagementsystem.services;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.repository.StudentRepository;

import java.util.List;

public class StudentService {

    // Service depends on Repository
    private StudentRepository repository;

    // Constructor Injection
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    // Add student with validation and business rules
    public void addStudent(StudentModel student) {

        // Validate ID
        if (student.getId() <= 0) {
            System.out.println("Invalid ID");
            return;
        }

        // Validate Name
        if (student.getName() == null ||
                student.getName().trim().isEmpty()) {

            System.out.println("Name cannot be empty");
            return;
        }

        // Validate Age
        if (student.getAge() <= 0) {
            System.out.println("Invalid Age");
            return;
        }

        // Prevent duplicate IDs
        if (repository.findById(student.getId()) != null) {
            System.out.println("Duplicate ID not allowed");
            return;
        }

        repository.addStudent(student);

        System.out.println(
                "Student added successfully: "
                        + student.getName()
        );
    }


    // Get all students
    public List<StudentModel> getAllStudents() {
        return repository.getAllStudents();
    }


    // Get student by ID
    public StudentModel getStudentById(int id) {
        return repository.findById(id);
    }


    // Delete student with validation
    public boolean deleteStudent(int id) {

        StudentModel student = repository.findById(id);

        if (student == null) {
            System.out.println("No student found with ID: " + id);
            return false;
        }

        repository.deleteStudent(id);

        System.out.println(
                "Deleted student: "
                        + student.getName()
        );

        return true;
    }


    // Update student with validation
    public boolean updateStudent(
            int id,
            String name,
            int age,
            String grade
    ) {

        StudentModel student = repository.findById(id);

        if (student == null) {
            System.out.println("No student found with ID: " + id);
            return false;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid Name");
            return false;
        }

        if (age <= 0) {
            System.out.println("Invalid Age");
            return false;
        }

        repository.updateStudent(id, name, age, grade);

        System.out.println(
                "Student updated successfully: "
                        + student.getName()
        );

        return true;
    }


    public List<StudentModel> sortById() {
        return repository.sortById();
    }

    public List<StudentModel> sortByName() {
        return repository.sortByName();
    }

    public List<StudentModel> sortByAge() {
        return repository.sortByAge();
    }

    public List<StudentModel> reverseStudents() {
        return repository.reverseStudents();
    }

    public List<StudentModel> shuffleStudents() {
        return repository.shuffleStudents();
    }

    public StudentModel getYoungestStudent() {
        return repository.getYoungestStudent();
    }

    public StudentModel getOldestStudent() {
        return repository.getOldestStudent();
    }
}