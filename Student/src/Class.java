import java.util.ArrayList;
import java.util.Objects;

public class Class {

    private StudentList studentList;
    private char id;

    public Class(char id) {
        this.id = id;
    }

    public char getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return id == aClass.id && Objects.equals(studentList, aClass.studentList);
    }


    @Override
    public String toString() {
        return "Class{" +
                "studentList=" + studentList +
                ", id=" + id +
                '}';
    }
}
