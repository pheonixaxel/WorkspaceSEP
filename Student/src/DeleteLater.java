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

public class DeleteLater
{
  public static void main(String[] args)
  {
    DeleteLater2.saveSchedule(new Schedule());
    // I tried to do a method here that saves the schedule in an XML file so that I can forward it to our website
    // beacause JS uses XML files not TXT files
  }
}
