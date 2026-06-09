package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private List<StudentModel> students = new ArrayList<>();

    public void addStudent(StudentModel student) {
        students.add(student);
    }

    public List<StudentModel> getAllStudents() {
        return students;
    }

    public StudentModel findById(int id) {
        for (StudentModel s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}