import java.util.Objects;

public class Student
{

  private String name;
  private int studentNumber;

  public Student(String name, int studentNumber)
  {
    this.name = name;
    this.studentNumber = studentNumber;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setStudentNumber(int studentNumber)
  {
    this.studentNumber = studentNumber;
  }

  public String getName()
  {
    return name;
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Student))return false;
    Student other = (Student)obj;
    return studentNumber == other.studentNumber && Objects.equals(name,
        other.name);
  }

  public String toString()
  {
    return "Student{" + "name='" + name + '\'' + ", studentNumber="
        + studentNumber + '}';
  }
}
