package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;

import java.util.*;

public class StudentRepository {
    // list of all the students in memory
    // private List<StudentModel> students = new ArrayList<>();

    // Hash Map (Main storage: ID -> Student)
    private Map<Integer, StudentModel> students = new HashMap<>();

    // Hash Set (used for tracking unique IDs)
    private Set<Integer> idSet = new HashSet<>();

    // List of all added STUDENT
    // public void addStudent(StudentModel student) {
    //     students.add(student);
    // }

    // Add using Hash Map + unique ID check
    public void addStudent(StudentModel student){

        if(idSet.contains(student.getId())){
            System.out.println("Duplicate ID");
            return;
        }

        idSet.add(student.getId());
        students.put(student.getId(), student);
    }

    // GET ALL STUDENTS
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // FIND STUDENT BY ID
    // public StudentModel findById(int id) {
    //     for (StudentModel s : students) {
    //         if (s.getId() == id) {
    //             return s;
    //         }
    //     }
    //     return null;
    // }

    // Using HashMap
    public StudentModel findById(int id) {
        return students.get(id);
    }

    // DELETE STUDENT
    // public boolean deleteStudent(int id) {
    //     return students.removeIf(s -> s.getId() == id);
    // }

    // Using HashMap + HashSet sync
    public boolean deleteStudent(int id) {

        StudentModel removed = students.remove(id);

        if (removed != null) {
            idSet.remove(id);
            return true;
        }

        return false;
    }

    // UPDATE STUDENT
    // public boolean updateStudent(int id, String name, int age, String grade) {
    //     for (StudentModel s : students) {
    //         if (s.getId() == id) {
    //             s.setName(name);
    //             s.setAge(age);
    //             s.setGrade(grade);
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // Using HashMap
    public boolean updateStudent(int id, String name, int age, String grade) {

        StudentModel student = students.get(id);

        if(student != null){
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            return true;
        }

        return false;
    }

    // SORT BY ID
    public List<StudentModel> sortById(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getId));
        return list;
    }

    // SORT BY NAME
    public List<StudentModel> sortByName(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getName));
        return list;
    }

    // SORT BY AGE
    public List<StudentModel> sortByAge(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getAge));
        return list;
    }

    // REVERSE LIST
    public List<StudentModel> reverseStudents(){
        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.reverse(list);
        return list;
    }

    // SHUFFLE LIST
    public List<StudentModel> shuffleStudents(){
        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.shuffle(list);
        return list;
    }

    // YOUNGEST STUDENT
    public StudentModel getYoungestStudent(){
        return Collections.min(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }

    // OLDEST STUDENT
    public StudentModel getOldestStudent() {
        return Collections.max(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }
}