package studentmanagementsystem.controller;

import studentmanagementsystem.model.StudentModel;
import studentmanagementsystem.services.StudentService;

import java.util.List;

public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    public void addStudent(int id, String name, int age, String grade) {
        StudentModel student = new StudentModel(id, name, age, grade);
        service.addStudent(student);
        System.out.println("Student added successfully");
    }

    public void showAllStudents() {
        List<StudentModel> students = service.getAllStudents();
        for (StudentModel s : students) {
            System.out.println(s);
        }
    }

    public void searchStudent(int id) {
        StudentModel student = service.getStudentById(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    public void deleteStudent(int id) {
        boolean deleted = service.deleteStudent(id);

        if (deleted) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    public void updateStudent(int id, String name, int age, String grade) {

        boolean updated = service.updateStudent(id, name, age, grade);

        if (updated) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }
}
