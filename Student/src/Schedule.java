import java.util.ArrayList;

public class Schedule
{
  private ArrayList<Lesson> lessons;

  public Schedule()
  {
    lessons = new ArrayList<Lesson>();
  }
  public ArrayList<Lessons> getAllLessons()
  {
    return lessons;
  }
  public Lesson getLesson(int index)
  {
    return lessons.get(index);
  }
  public ArrayList<Lesson> getLessonsForDate(String date)
  {
    ArrayList<Lesson> rtrn =new ArrayList<Lesson>();
    for(int i=0;i<lessons.size();i++)
    {
      if(lessons.get(i).getDate().equals(date))rtrn.add(lessons.get(i));
    }
    return rtrn;
  }
  public void addLesson(Lesson lesson)
  {
    lessons.add(lesson);
  }
  public void removeLessons(Lesson lesson)
  {
    lessons.remove(lesson);
  }

  public boolean equals(Object obj)
  {
    if(!(obj instanceof Schedule))return false;
    Schedule other = (Schedule)obj;
    for(int i=0;i<lessons.size();i++)
    {
      if(!(lessons.get(i).equals(other.lessons.get(i))))return false;
    }
    return true;
  }
}
