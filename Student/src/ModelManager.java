import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ModelManager
{
  private String fileName;
  private Schedule schedule;

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
    list.removeStudent(student);
  }

  public static void addLesson(Lesson lesson, Schedule schedule)
  {
    schedule.addLesson(lesson);
  }

  public static void removeLesson(Lesson lesson, Schedule schedule)
  {
    schedule.removeLesson(lesson);
  }

  public void saveSchedule()
  {
    try
    {
      MyFileHandler.appendToTextFile("schedule.txt", schedule.toString());
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }
  }

  public void createSchedule()
  {
    try
    {
      MyFileHandler.writeToTextFile("schedule.txt", "");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

  }

  public ArrayList<Lesson> getAllLessons(Schedule schedule)
  {
    return schedule.getAllLessons();
  }

  public ArrayList<Lesson> getLessonsForDate(String date, Schedule schedule)
  {
    return schedule.getLessonsForDate(date);
  }
}
