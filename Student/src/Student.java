import java.util.Objects;

public class Student {
// aici ar trebui sa fie numa un comment  kjg

    private String name;
    private int studentNumber;

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }
    public int getStudentNumber() {
        return studentNumber;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && Objects.equals(name, student.name);
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
