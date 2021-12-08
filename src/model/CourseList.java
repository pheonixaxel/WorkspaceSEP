package model;

import java.io.Serializable;
import java.util.ArrayList;
public class CourseList implements Serializable
{
  private ArrayList<Course> courses;

  public CourseList()
  {
    courses=new ArrayList<Course>();
  }
  public ArrayList<Course> getAllCourses()
  {
    return courses;
  }
  public void addCourse(Course course)
  {
    courses.add(course);
  }
  public Course getCourse(String id)
  {
    for(int i=0;i< courses.size();i++)
    {
      if(courses.get(i).getId().equals(id))return courses.get(i);
    }
    return null;
  }
  public boolean contains(Course course)
  {
    for(int i=0;i<courses.size();i++)
    {
      if(courses.get(i).equals(course))return true;
    }
    return false;
  }
  public Course getCourse(Course course)
  {
    return courses.get(courses.indexOf(course));
  }
  public boolean equals(Object obj)
  {
    if(!(obj instanceof CourseList))return false;
    CourseList other=(CourseList) obj;
    for(int i=0;i<courses.size();i++)
    {
      if(!courses.get(i).equals(other.courses.get(i)))return false;
    }
    return true;
  }
  public String toString()
  {
    String rtrn="";
    for(int i=0;i< courses.size();i++)rtrn+=courses.get(i)+" / ";
    return rtrn;
  }
}
