package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentRepository {
//list of all the students in memory
    private List<StudentModel> students = new ArrayList<>();

    // List of all added STUDENT
    public void addStudent(StudentModel student) {
        students.add(student);
    }

    // GET ALL STUDENTS
    public List<StudentModel> getAllStudents() {
        return students;
    }

    // FIND STUDENT BY ID
    public StudentModel findById(int id) {
        for (StudentModel s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // DELETE STUDENT
    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }

    // UPDATE STUDENT
    public boolean updateStudent(int id, String name, int age, String grade) {
        for (StudentModel s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setGrade(grade);
                return true;
            }
        }
        return false;
    }
    //Sort Feature
    //Sort by ID
    //Collection Utilities
    public List<StudentModel> sortById(){
        Collections.sort(students,Comparator.comparing(StudentModel::getId));
        return students;
    }
    public List<StudentModel> sortByName(){
        Collections.sort(students , Comparator.comparing(StudentModel::getName));
        return students;
    }
    public List<StudentModel> sortByAge(){
        Collections.sort(students , Comparator.comparing(StudentModel::getAge));
        return students;
    }
    //Reverse
    public List<StudentModel> reverseStudents(){
        Collections.reverse(students);
        return students;
    }
}