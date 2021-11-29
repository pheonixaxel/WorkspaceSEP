import java.util.Objects;

public class Student {

    private String name;
    private int studentNumber;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }
// SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
// GETTERS
    public String getName() {
        return name;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
// I DO NOT KNOW HOW TO NAME THESE... i don't even know why i started to write these comments in the first place

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && Objects.equals(name, student.name);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
