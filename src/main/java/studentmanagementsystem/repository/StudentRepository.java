package studentmanagementsystem.repository;

import studentmanagementsystem.model.StudentModel;

import java.util.*;

public class StudentRepository {
    //list of all the students in memory
    // private List<StudentModel> students = new ArrayList<>();

    //Hash Map
    private Map<Integer, StudentModel> students = new HashMap<>();

    // List of all added STUDENT
    //public void addStudent(StudentModel student) {
    // students.add(student);
    //}

    //Add using Hash Map
    public void addStudent(StudentModel student){
        students.put(student.getId(), student);
    }

    // GET ALL STUDENTS
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // FIND STUDENT BY ID
    //public StudentModel findById(int id) {
    //  for (StudentModel s : students) {
    //     if (s.getId() == id) {
    //        return s;
    //   }
    //}
    //return null;
    //}

    //Using HashMap
    public StudentModel findById(int id) {
        return students.get(id);
    }

    // DELETE STUDENT
    //public boolean deleteStudent(int id) {
    //  return students.removeIf(s -> s.getId() == id);
    //}

    //Using HashMap
    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }

    // UPDATE STUDENT
//    public boolean updateStudent(int id, String name, int age, String grade) {
//        for (StudentModel s : students) {
//            if (s.getId() == id) {
//                s.setName(name);
//                s.setAge(age);
//                s.setGrade(grade);
//                return true;
//            }
//        }
//        return false;
//    }

    //Using HashMap
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

    //Sort Feature
    //Sort by ID
    //Collection Utilities
    public List<StudentModel> sortById(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getId));
        return list;
    }

    public List<StudentModel> sortByName(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getName));
        return list;
    }

    public List<StudentModel> sortByAge(){
        List<StudentModel> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(StudentModel::getAge));
        return list;
    }

    //Reverse
    public List<StudentModel> reverseStudents(){
        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.reverse(list);
        return list;
    }

    //Shuffle
    public List<StudentModel> shuffleStudents(){
        List<StudentModel> list = new ArrayList<>(students.values());
        Collections.shuffle(list);
        return list;
    }

    // GET YOUNGEST STUDENT (was wrongly named before)
    public StudentModel getYoungestStudent(){
        return Collections.min(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }

    public StudentModel getOldestStudent() {
        return Collections.max(
                students.values(),
                Comparator.comparing(StudentModel::getAge)
        );
    }
}