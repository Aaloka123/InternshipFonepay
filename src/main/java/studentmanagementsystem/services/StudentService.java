package studentmanagementsystem.services;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.repository.StudentRepository;

import java.util.List;

// Service layer: contains business logic (middle layer)
public class StudentService {

    private StudentRepository repository;

    // Constructor injection (GOOD PRACTICE)
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ADD student
    public void addStudent(StudentModel student) {
        repository.addStudent(student);
    }

    // GET all students
    public List<StudentModel> getAllStudents() {
        return repository.getAllStudents();
    }

    // SEARCH student
    public StudentModel getStudentById(int id) {
        return repository.findById(id);
    }

    // DELETE student
    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    // UPDATE student
    public boolean updateStudent(int id, String name, int age, String grade) {
        return repository.updateStudent(id, name, age, grade);
    }
     //Sort Methods

//By Id
    public List<StudentModel> sortById() {
        return repository.sortById();
    }
    public  List<StudentModel> sortByName(){return repository.sortByName();}
    public  List<StudentModel> sortByAge(){return repository.sortByAge();}



}