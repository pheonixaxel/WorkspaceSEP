package model;

import java.io.Serializable;

public class Student extends Person
{
  private int studentNumber;

  public Student(String name, int studentNumber)
  {
    super(name);
    this.studentNumber = studentNumber;
  }

  public void setName(String name)
  {
    super.setName(name);
  }

  public void setStudentNumber(int studentNumber)
  {
    this.studentNumber = studentNumber;
  }

  public String getName()
  {
    return super.getName();
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Student))return false;
    Student other = (Student)obj;
    return studentNumber == other.studentNumber && super.equals(obj);
  }

  public String toString()
  {
    return super.toString()+","+studentNumber;
  }
}
