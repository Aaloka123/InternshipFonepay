package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;

import java.util.*;

public class StudentRepository {

    private Map<Integer, StudentModel> students = new HashMap<>();
    private Set<Integer> idSet = new HashSet<>();

    // ADD
    public void addStudent(StudentModel student) {
        students.put(student.getId(), student);
        idSet.add(student.getId());
    }

    // GET ALL
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // FIND
    public StudentModel findById(int id) {
        return students.get(id);
    }

    // DELETE
    public boolean deleteStudent(int id) {
        StudentModel removed = students.remove(id);
        if (removed != null) {
            idSet.remove(id);
            return true;
        }
        return false;
    }

    // UPDATE
    public boolean updateStudent(int id, String name, int age, String grade) {
        StudentModel student = students.get(id);
        if (student == null) return false;

        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        return true;
    }

    // DUPLICATE CHECK
    public boolean isDuplicateId(int id) {
        return idSet.contains(id);
    }

    // TOTAL
    public int getTotalStudents() {
        return students.size();
    }

    // EMPTY CHECK
    public boolean isEmpty() {
        return students.isEmpty();
    }

    // IDS
    public List<Integer> getAllStudentIds() {
        return new ArrayList<>(students.keySet());
    }

    // REPORT
    public void printFullReport() {
        for (Map.Entry<Integer, StudentModel> entry : students.entrySet()) {
            StudentModel s = entry.getValue();

            System.out.println("ID: " + entry.getKey());
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Grade: " + s.getGrade());
            System.out.println("----------------------");
        }
    }
}