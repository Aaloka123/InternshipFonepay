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
}