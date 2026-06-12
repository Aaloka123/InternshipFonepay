package studentmanagementsystem.services;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.repository.StudentRepository;

import java.util.*;

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ADD STUDENT
    public void addStudent(StudentModel student) {

        if (student.getId() <= 0) {
            System.out.println("Invalid ID");
            return;
        }

        if (student.getName() == null || student.getName().trim().isEmpty()) {
            System.out.println("Invalid Name");
            return;
        }

        if (student.getAge() <= 0) {
            System.out.println("Invalid Age");
            return;
        }

        if (repository.isDuplicateId(student.getId())) {
            System.out.println("Duplicate ID not allowed");
            return;
        }

        repository.addStudent(student);
        System.out.println("Student added successfully: " + student.getName());
    }

    // GET ALL
    public List<StudentModel> getAllStudents() {
        return repository.getAllStudents();
    }

    // SEARCH
    public StudentModel getStudentById(int id) {
        return repository.findById(id);
    }

    // DELETE
    public boolean deleteStudent(int id) {
        StudentModel student = repository.findById(id);

        if (student == null) {
            System.out.println("Student not found");
            return false;
        }

        repository.deleteStudent(id);
        System.out.println("Deleted student: " + student.getName());
        return true;
    }

    // UPDATE
    public boolean updateStudent(int id, String name, int age, String grade) {

        StudentModel student = repository.findById(id);

        if (student == null) {
            System.out.println("Student not found");
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
        System.out.println("Student updated successfully");
        return true;
    }

    // SORT BY ID
    public List<StudentModel> sortById() {
        List<StudentModel> list = repository.getAllStudents();
        list.sort(Comparator.comparing(StudentModel::getId));
        return list;
    }

    // SORT BY NAME
    public List<StudentModel> sortByName() {
        List<StudentModel> list = repository.getAllStudents();
        list.sort(Comparator.comparing(StudentModel::getName));
        return list;
    }

    // SORT BY AGE
    public List<StudentModel> sortByAge() {
        List<StudentModel> list = repository.getAllStudents();
        list.sort(Comparator.comparing(StudentModel::getAge));
        return list;
    }

    // REVERSE
    public List<StudentModel> reverseStudents() {
        List<StudentModel> list = repository.getAllStudents();
        Collections.reverse(list);
        return list;
    }

    // SHUFFLE
    public List<StudentModel> shuffleStudents() {
        List<StudentModel> list = repository.getAllStudents();
        Collections.shuffle(list);
        return list;
    }

    // YOUNGEST
    public StudentModel getYoungestStudent() {
        return Collections.min(
                repository.getAllStudents(),
                Comparator.comparing(StudentModel::getAge)
        );
    }

    // OLDEST
    public StudentModel getOldestStudent() {
        return Collections.max(
                repository.getAllStudents(),
                Comparator.comparing(StudentModel::getAge)
        );
    }

    // TOTAL
    public int getTotalStudents() {
        return repository.getTotalStudents();
    }

    // EMPTY
    public boolean isEmpty() {
        return repository.isEmpty();
    }

    // REPORT
    public void printFullReport() {
        repository.printFullReport();
    }
}