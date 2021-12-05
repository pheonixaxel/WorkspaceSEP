import java.util.ArrayList;
import java.util.Objects;

public class TeacherList
{
  private ArrayList<Teacher> teachers;

  public TeacherList(ArrayList<Teacher> teachers)
  {
    this.teachers = teachers;
  }

  public ArrayList<Teacher> getAllTeachers()
  {
    return teachers;
  }

  public Teacher getTeacher(int index)
  {
    return teachers.get(index);
  }

  public void addTeacher(Teacher teacher)
  {
    teachers.add(teacher);
  }

  public void removeTeacher(Teacher teacher)
  {
    teachers.remove(teacher);
  }

  public int size()
  {
    return teachers.size();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeacherList))
    {
      return false;
    }

    TeacherList other = (TeacherList) obj;

    for (int i = 0; i < teachers.size(); i++)
    {
      if (!(teachers.get(i).equals(other.teachers.get(i))))
      {
        return false;
      }
    }
    return true;
  }

  public String toString()
  {
    String rtrn="";
    for(int i=0;i<teachers.size();i++)
    {
      rtrn+=teachers.get(i).toString()+" ";
    }
    return rtrn;
  }
}
