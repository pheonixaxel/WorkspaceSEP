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

public class DeleteLater2
{
  public static final String filePath = "schedule.xml";

  public static void saveSchedule(Schedule schedule)
  {
    try
    {
      // We create the necesary object to be able to create an .xml file
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
        elements.add(document.createElement("lesson"));
        elements.get(i).appendChild(document.createTextNode(lessons.get(i).toString()));
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
