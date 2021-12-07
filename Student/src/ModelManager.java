import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ModelManager
{
  private Schedule schedule;
  private ClassList classList;
  public static final String filePath = "schedule.xml";

  public ModelManager()
  {
    schedule = new Schedule();
    classList = new ClassList();
  }

  public ArrayList<Class> getAllClasses()
  {
    return classList.getAllClasses();
  }

  public void addStudent(Student student, StudentList list)
  {
    list.addStudent(student);
  }

  public void removeStudent(Student student, StudentList list)
  {
    list.removeStudent(student);
  }

  public void addLesson(Lesson lesson)
  {
    schedule.addLesson(lesson);
  }

  public void removeLesson(Lesson lesson)
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
      MyFileHandler.writeToTextFile("schedule.txt", schedule.toString());
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }

  }

  public ArrayList<Lesson> getAllLessons()
  {
    return schedule.getAllLessons();
  }

  public ArrayList<Lesson> getLessonsForDate(String date)
  {
    return schedule.getLessonsForDate(date);
  }

  public static void saveSchedule(Schedule schedule)
  {
    try
    {
      // We create the necessary object to be able to create an .xml file
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument();

      // Then we assign the root element and tag it "schedule"
      Element root = document.createElement("schedule");

      // We proceed to go through all lessons and add them to the document
      ArrayList<Lesson> lessons = schedule.getAllLessons();
      Element days[] = new Element[5];
      ArrayList<Element> elements = new ArrayList<Element>();
      Clock prev = new Clock(0,0);
      int c=-1;
      for(int i=0;i<lessons.size();i++)
      {
        if(prev.compare(lessons.get(i).getDate())==-1){
          days[++c] = document.createElement("day");
          root.appendChild(days[c]);
        }
        //Create lesson element
        elements.add(document.createElement("lesson"));
        //Add id
        elements.get(i).appendChild(document.createElement("id").appendChild(document.createTextNode(lessons.get(i).getCourse().getId())));
        //Add teachers
        elements.get(i).appendChild(document.createElement("teacher").appendChild(document.createTextNode(lessons.get(i).getCourse().getAllTeachers().toString())));
        //Add rooms
        elements.get(i).appendChild(document.createElement("room").appendChild(document.createTextNode(lessons.get(i).getCourse().getRoom().toString())));
        //Add beginTime
        elements.get(i).appendChild(document.createElement("beginTime").appendChild(document.createTextNode(lessons.get(i).getBeginTime().toString())));
        //Add endTime
        elements.get(i).appendChild(document.createElement("endTime").appendChild(document.createTextNode(lessons.get(i).getEndTime().toString())));
        days[c].appendChild(elements.get(i));
      }

      // Last we actually convert the DOM object to a xml file
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new File(filePath));
    }
    catch(ParserConfigurationException e){System.out.println(e.getMessage());}
    catch (TransformerException e){System.out.println(e.getMessage());}
  }
}
