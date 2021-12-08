package model;

import java.io.Serializable;

public class Student /*extends Person*/ implements Serializable
{
  private String name;
  private int studentNumber;

  public Student(String name, int studentNumber)
  {
    //super(name);
    this.name=name;
    this.studentNumber = studentNumber;
  }

  public void setName(String name)
  {
    this.name=name;
    //super.setName(name);
  }

  public void setStudentNumber(int studentNumber)
  {
    this.studentNumber = studentNumber;
  }

  public String getName()
  {
    return name;
    //return super.getName();
  }

  public int getStudentNumber()
  {
    return studentNumber;
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Student))return false;
    Student other = (Student)obj;
    return name.equals(other.name) && studentNumber==other.studentNumber;
    //return studentNumber == other.studentNumber && super.equals(obj);
  }

  public String toString()
  {
    return name+","+studentNumber;
    //return super.toString()+","+studentNumber;
  }
}
