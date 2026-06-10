package studentmanagementsystem.model;

public class StudentModel {
//single Student object
    private int id;
    private String name;
    private int age;
    private String grade;
     //Constructor used to create Student Objects
    public StudentModel(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
//Getter (used to access private data)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }
//Setter (used for updating student data)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    }
