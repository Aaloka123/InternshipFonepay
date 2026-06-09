package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<StudentModel> students = new ArrayList<>();

    // ADD STUDENT
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

    // UPDATE STUDENT (FIXED)
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
}