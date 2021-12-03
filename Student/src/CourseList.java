import java.util.ArrayList;
public class CourseList
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
  public Course getCourse(int index)
  {
    return courses.get(index);
  }
  public void addCourse(Course course)
  {
    courses.add(course);
  }
  public boolean contains(Course course)
  {
    for(int i=0;i<courses.size();i++)
    {
      if(courses.get(i).equals(course))return true;
    }
    return false;
  }
  public Course getCourse(Course course)//DELETE THIS COMMENT
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
