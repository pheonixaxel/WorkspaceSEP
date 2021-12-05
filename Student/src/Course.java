import javax.swing.*;
import javax.xml.transform.Templates;
import java.util.ArrayList;

public class Course
{
  private String id;
  private int semester;
  private int ects;
  private ArrayList<Room> rooms;
  private StudentList students;
  private TeacherList teachers;

  public Course(int semester, String id)
  {
    ects=0;
    this.id=id;
    this.semester=semester;
    rooms = new ArrayList<Room>();
  }

  public int getEcts()
  {
    return ects;
  }

  public int getSemester()
  {
    return semester;
  }

  public void setEcts(int ects)
  {
    this.ects = ects;
  }

  public String getId()
  {
    return id;
  }

  public void addStudent(Student student)
  {
    students.addStudent(student);
  }

  public void removeStudent(Student student)
  {
    students.removeStudent(student);
  }

  public void addTeacher(Teacher teacher)
  {
    teachers.addTeacher(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    teachers.removeTeacher(teacher);
  }

  public ArrayList<Room> getRoom()
  {
    return rooms;
  }

  public ArrayList<Student> getAllStudents()
  {
    return students.getAllStudents();
  }

  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers.getAllTeachers();
  }

  public Course copy()
  {
    Course rtrn = new Course(semester,id);
    rtrn.setEcts(ects);
    rtrn.students=students;
    rtrn.teachers=teachers;
    return rtrn;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Course))
      return false;
    Course other = (Course) obj;
    return id == other.id && ects == other.ects && semester==other.semester
        && rooms.equals(other.rooms);
  }

  public String toString()
  {
    return semester+","+ id +"," + teachers + "," + rooms + ",";
  }
}
