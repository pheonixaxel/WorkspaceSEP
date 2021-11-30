import java.util.ArrayList;
import java.util.Objects;

public class StudentList
{

  private ArrayList<Student> students;

  public StudentList(ArrayList<Student> students)
  {
    this.students = students;
  }

  public ArrayList<Student> getAllStudents()
  {
    return students;
  }

  public Student getStudent(int index)
  {
    return students.get(index);
  }

  public void addStudent(Student student)
  {
    students.add(student);
  }

  public void removeStudent(Student student)
  {
    students.remove(student);
  }

  public int size()
  {
    return students.size();
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    StudentList that = (StudentList) o;
    return Objects.equals(students, that.students);
  }

  @Override public String toString()
  {
    return "StudentList{" + "students=" + students + '}';
  }
}
