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

  public boolean equals(Object obj)
  {
    if(!(obj instanceof StudentList))return false;
    StudentList other=(StudentList)obj;
    for(int i=0;i<students.size();i++)
    {
      if(!students.get(i).equals(other.students.get(i)))return false;
    }
    return true;
  }

  public String toString()
  {
    return "StudentList{" + "students=" + students + '}';
  }
}
