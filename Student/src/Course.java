import javax.xml.transform.Templates;
import java.util.ArrayList;

public class Course
{
  private String id;
  private int ects;
  private ArrayList<Room> rooms;
  private StudentList students;
  private TeacherList teachers;

  public Course(String id)
  {
    ects=0;
    this.id=id;
    rooms = new ArrayList<Room>();
  }

  public int getEcts()
  {
    return ects;
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
    Course rtrn = new Course(id);
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
    return id == other.id && ects == other.ects
        && rooms.equals(other.rooms);
  }

  public String toString()
  {
    return "Course id: " + id + "\nECTS points: "
        + ects + "\nRoom: " + rooms;
  }
}
