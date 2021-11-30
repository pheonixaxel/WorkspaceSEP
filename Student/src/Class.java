import java.util.ArrayList;
import java.util.Objects;

public class Class
{
  private StudentList students;
  private char id;

  public Class(char id)
  {
    this.id = id;
    students=new StudentList();
  }

  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  public void removeStudent(Student student)
  {
    students.removeStudent(student);
  }

  public char getId()
  {
    return id;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Class))
      return false;
    Class other = (Class) obj;
    return students.equals(other.students) && id == other.id;
  }

  public String toString()
  {
    return "Class{" + "studens=" + students + ", id=" + id + '}';
  }
}
