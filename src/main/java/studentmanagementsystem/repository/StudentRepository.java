package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;

import java.util.*;

public class StudentRepository {

    // Main storage using HashMap (ID -> Student)
    // Provides O(1) average time for insert, search, update, and delete
    private Map<Integer, StudentModel> students = new HashMap<>();


    // Store a student in the repository
    public void addStudent(StudentModel student) {
        students.put(student.getId(), student);
    }


    // Return all students as a List
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(students.values());
    }


    // Find a student by ID
    public StudentModel findById(int id) {
        return students.get(id);
    }


    // Delete a student by ID
    // Returns true if deletion succeeds
    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }


    // Update student details
    // Returns false if student does not exist
    public boolean updateStudent(int id, String name, int age, String grade) {

        StudentModel student = students.get(id);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);

        return true;
    }


    // Sort students by ID
    public List<StudentModel> sortById() {

        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getId));

        return list;
    }


    // Sort students by Name
    public List<StudentModel> sortByName() {

        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getName));

        return list;
    }


    // Sort students by Age
    public List<StudentModel> sortByAge() {

        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getAge));

        return list;
    }


    // Return students in reverse order
    public List<StudentModel> reverseStudents() {

        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.reverse(list);

        return list;
    }


    // Return students in random order
    public List<StudentModel> shuffleStudents() {

        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.shuffle(list);

        return list;
    }


    // Return the youngest student
    public StudentModel getYoungestStudent() {

        if (students.isEmpty()) {
            return null;
        }

        return Collections.min(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }


    // Return the oldest student
    public StudentModel getOldestStudent() {

        if (students.isEmpty()) {
            return null;
        }

        return Collections.max(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }
}