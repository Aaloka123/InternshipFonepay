package studentmanagementsystem.services;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public void addStudent(StudentModel student) {
        repository.addStudent(student);
    }

    public List<StudentModel> getAllStudents() {
        return repository.getAllStudents();
    }

    public StudentModel getStudentById(int id) {
        return repository.findById(id);
    }

    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    public boolean updateStudent(int id, String name, int age, String grade) {
        return repository.updateStudent(id, name, age, grade);
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