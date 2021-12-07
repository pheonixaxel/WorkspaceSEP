package model;

public class Class
{
  private StudentList students;
  private String id;
  private int semester;
  private CourseList courses;
  private Schedule schedule;

  public Class(int semester,String id)
  {
    this.id = id;
    this.semester=semester;
    students=new StudentList();
    courses=new CourseList();
    schedule=new Schedule();
  }

  public Schedule getSchedule()
  {
    return schedule;
  }

  public StudentList getStudents()
  {
    return students;
  }

  public int getSemester()
  {
    return semester;
  }

  public Course getCourse(int index)
  {
    return courses.getCourse(index);
  }

  public boolean contains(Course course)
  {
    return courses.contains(course);
  }
  public Course getCourse(Course course)
  {
    return courses.getCourse(course);
  }
  public void addCourse(Course course)
  {
    courses.addCourse(course);
  }

  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  public void removeStudent(Student student)
  {
    students.removeStudent(student);
  }

  public String getId()
  {
    return id;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Class))
      return false;
    Class other = (Class) obj;
    return students.equals(other.students) && id.equals(other.id) && semester==other.semester;
  }

  public String toString()
  {
    return semester+id+","+students;
  }
}
