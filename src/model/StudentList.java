package model;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentList implements Serializable
{

  private ArrayList<Student> students;

  public StudentList()
  {
    students = new ArrayList<Student>();
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
    return "model.StudentList{" + "students=" + students + '}';
  }
}
