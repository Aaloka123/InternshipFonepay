package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;

import java.util.*;

public class StudentRepository {

    // Main storage using HashMap (ID Student)
    // HashMap provides fast O(1) average operations for insert, search, delete
    private Map<Integer, StudentModel> students = new HashMap<>();


    // Add new student with duplicate ID check
    public void addStudent(StudentModel student) {

        // Prevent duplicate IDs
        if (students.containsKey(student.getId())) {
            System.out.println("Duplicate ID not allowed");
            return;
        }

        // Insert student into map
        students.put(student.getId(), student);

        System.out.println("Student added successfully:" + student.getName());
    }


    // Get all students as a list
    public List<StudentModel> getAllStudents() {

        // Convert Map values into List for easy display/sorting
        return new ArrayList<>(students.values());
    }


    // Find student by ID
    public StudentModel findById(int id) {

        // Direct lookup in HashMap (O(1) average time)
        return students.get(id);
    }


    // Delete student by ID
//    public boolean deleteStudent(int id) {
//
//        // remove() returns removed object or null
//        StudentModel removed = students.remove(id);
//
//        return removed != null;
//    }

    // Delete student by ID (UPDATED HANDLING)
    public boolean deleteStudent(int id) {

        // Step 1: Check if student exists
        StudentModel student = students.get(id);

        if (student == null) {
            System.out.println("No student Found with ID:" + id);
            return false;   // IMPORTANT FIX
        }

        // Step 2 :Remove Student
        students.remove(id);

        // Step 3 Confirmation message
        System.out.println("Deleted student:" + student.getName());

        return true;
    }


    // Update student details
    public boolean updateStudent(int id, String name, int age, String grade) {

        // Fetch student from map
        StudentModel student = students.get(id);

        // If student does not exist
        if (student == null) {
            System.out.println("No student Found with ID:" + id);
            return false;
        }

        // Update existing object
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);

        //Confirmation Message
        System.out.println("Student updated Successfully:" + student.getName());

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


    // Reverse student list order
    public List<StudentModel> reverseStudents() {

        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.reverse(list);
        return list;
    }


    // Shuffle student list randomly
    public List<StudentModel> shuffleStudents() {

        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.shuffle(list);
        return list;
    }


    // Get youngest student
    public StudentModel getYoungestStudent() {

        return Collections.min(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }


    // Get oldest student
    public StudentModel getOldestStudent() {

        return Collections.max(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }
}