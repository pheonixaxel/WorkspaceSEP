import java.util.ArrayList;

public class Schedule
{
  private ArrayList<Lesson> lessons;

  public Schedule()
  {
    lessons = new ArrayList<Lesson>();
  }

  public ArrayList<Lesson> getAllLessons()
  {
    return lessons;
  }

  public Lesson getLesson(int index)
  {
    return lessons.get(index);
  }

  public ArrayList<Lesson> getLessonsForDate(String date)
  {
    ArrayList<Lesson> rtrn = new ArrayList<Lesson>();
    for (int i = 0; i < lessons.size(); i++)
    {
      if (getLesson(i).getDate().compare(date)==0)
        rtrn.add(getLesson(i));
    }
    return rtrn;
  }

  public void addLesson(Lesson lesson)
  {
    lessons.add(lesson);
  }

  public void removeLesson(Lesson lesson)
  {
    lessons.remove(lesson);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Schedule))
      return false;
    Schedule other = (Schedule) obj;
    for (int i = 0; i < lessons.size(); i++)
    {
      if (!(lessons.get(i).equals(other.lessons.get(i))))
        return false;
    }
    return true;
  }
  public String toString()
  {
    String rtrn="";
    for(int i=0;i<lessons.size();i++)
    {
      rtrn+=lessons.get(i)+"\n";
    }
    return rtrn;
  }
}
