package studentmanagementsystem.controller;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.services.StudentService;

import java.util.List;

// Controller handles communication between UI and Service
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ADD student
    public void addStudent(int id, String name, int age, String grade) {
        StudentModel student = new StudentModel(id, name, age, grade);
        service.addStudent(student);
    }

    // GET ALL students
    public List<StudentModel> getAllStudents() {
        return service.getAllStudents();
    }

    // SEARCH student
    public StudentModel searchStudent(int id) {
        return service.getStudentById(id);
    }

    // DELETE student
    public boolean deleteStudent(int id) {
        return service.deleteStudent(id);
    }

    // UPDATE student
    public boolean updateStudent(int id, String name, int age, String grade) {
        return service.updateStudent(id, name, age, grade);
    }

    // SORT METHODS

    public List<StudentModel> sortById() {
        return service.sortById();
    }


}