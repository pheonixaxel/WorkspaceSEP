package model;

import java.io.FileNotFoundException;
import java.io.IOException;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Class;

import util.*;

public class ModelManager
{
  public ClassList getAllClasses()
  {
    ClassList classList = new ClassList();

    try{
      classList = (ClassList) MyFileHandler.readFromBinaryFile("classes.bin");
    }
    catch(FileNotFoundException e){System.out.println("File was not found");}
    catch(IOException e){System.out.println(e.getMessage());}
    catch(ClassNotFoundException e){System.out.println("Class not found");}
    return classList;
  }

  public RoomList getAllRooms()
  {
    RoomList roomList = new RoomList();

    try{
      roomList = (RoomList) MyFileHandler.readFromBinaryFile("rooms.bin");
    }
    catch(FileNotFoundException e){System.out.println("File was not found");}
    catch(IOException e){System.out.println("IO Exception");}
    catch(ClassNotFoundException e){System.out.println("Class not found");}
    return roomList;
  }
  public void addStudent(Student student, StudentList list)
  {
    list.addStudent(student);
  }

  public void addStudentToClass(Student student, Class clas){
    clas.addStudent(student);
  }

  public void removeStudent(Student student, StudentList list)
  {
    list.removeStudent(student);
  }

  public void addLesson(Lesson lesson, Class clas)
  {
    clas.getSchedule().addLesson(lesson);
  }

  public void removeLesson(Lesson lesson, Class clas)
  {
    clas.getSchedule().removeLesson(lesson);
  }

  public void saveSchedule(Class clas)
  {
    try
    {
      String filePath = "schedule"+clas.getSemester()+clas.getId()+".bin";
      MyFileHandler.writeToBinaryFile(filePath, clas.getSchedule());
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }
    catch (IOException e){System.out.println(e.getMessage());}
  }

  public void saveClasses(ClassList classList)
  {
    try{
    MyFileHandler.writeToBinaryFile("classes.bin",classList);
    }
    catch(FileNotFoundException e){System.out.println("File was not found");}
    catch(IOException e){System.out.println(e.getMessage());}
  }

  public ArrayList<Lesson> getAllLessons(Class clas)
  {
    return clas.getSchedule().getAllLessons();
  }

  public ArrayList<Lesson> getLessonsForDate(String date,Class clas)
  {
    return clas.getSchedule().getLessonsForDate(date);
  }

  public Schedule getScheduleFromFile(String filePath)
  {
    Schedule rtrn= new Schedule();
    try{
      rtrn = (Schedule)MyFileHandler.readFromBinaryFile(filePath);
    }
    catch(FileNotFoundException e){System.out.println("File not found");}
    catch (IOException e){System.out.println(e.getMessage());}
    catch (ClassNotFoundException e){System.out.println("Classes not found");}
    return rtrn;
  }

  public static void sendSchedule(Class clas)
  {
    String filePath = "schedule"+clas.getSemester()+ clas.getId();
    try
    {
      // We create the necessary object to be able to create an .xml file
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument();

      // Then we assign the root element and tag it "schedule"
      Element root = document.createElement("schedule");

      // We proceed to go through all lessons and add them to the document
      ArrayList<Lesson> lessons = clas.getSchedule().getAllLessons();
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
