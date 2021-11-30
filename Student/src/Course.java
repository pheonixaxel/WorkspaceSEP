import javax.xml.transform.Templates;
import java.util.ArrayList;

public class Course
{
    private String name;
    private int id;
    private int ects;
    private ArrayList<Room> rooms; //change in diagram to plural

    public Course(String name, int id, int ects)
    {
        this.name=name;
        this.id=id;
        rooms = new ArrayList<Room>();
    }
    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Course)
        {
            return false;
        }
        Course other = (Course) obj;
        return name.equals(other.name) && id==other.id && ects==other.ects && rooms.equals(other.rooms);
    }
    public String toString()
    {
        return "Course name: " + name + "\nCourse id: " + id + "\nECTS points: " + ects + "\nRoom: " + rooms;
    }

    public ArrayList<Room> getRoom()
    {
        return rooms;
    }
    public ArrayList<Student> getAllStudents()
    {

    }
    public ArrayList<Teacher> getAllTeachers()
    {

    }

}
