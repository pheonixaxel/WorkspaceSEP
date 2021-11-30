import java.util.ArrayList;

public class ModelManager
{
  private String fileName;

  public ModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public static void addStudent(Student student, StudentList list)
  {
    list.addStudent(student);
  }

  public static void removeStudent(Student student, StudentList list)
  {
    list.removeStudent(student) }
  public static void addLesson (Lesson
    lesson, Schedule schedule)
    {
      schedule.addLesson(lesson);
    }
    public static void removeLesson (Lesson lesson, Schedule schedule)
    {
      schedule.removeLesson(lesson);
    }
  }
  /*public void saveSchedule()
  {

  }
  public void createSchedule()
  {

  }*/
  public ArrayList<Lesson> getAllLessons (Schedule schedule)
  {
    return schedule.getAllLessons();
  }
  public ArrayList<Lesson> getLessonsForDate (String date, Schedule schedule)
  {
    return schedule.getLessonsForDate(date);
  }
}
