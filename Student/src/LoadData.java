import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.SplittableRandom;
import java.util.HashSet;

public class LoadData {
    public static void main(String[] args)
    {

        // CLASSES
        ArrayList<Class> classes = new ArrayList<Class>();
        String[]studentArray= null;
        try{
            studentArray = MyFileHandler.readArrayFromTextFile("students.txt");
            for(int i=0;i<studentArray.length;i++)
            {
                String[] tempString = studentArray[i].split(",");
                Class tempClass = new Class(Integer.parseInt(tempString[0]),tempString[1]);
                Student tempStudent = new Student(tempString[3],Integer.parseInt(tempString[2]));
                if(!classes.contains(tempClass))classes.add(tempClass);
                classes.get(classes.indexOf(tempClass)).addStudent(tempStudent);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found or could not be opened");
        }
        // CLASSES

        // COURSES
        ArrayList<Course> courses = new ArrayList<Course>();
        String[] courseArray = null;
        try{
            courseArray = MyFileHandler.readArrayFromTextFile("courses.txt");
            for(int i=0;i<courseArray.length;i++)
            {
                String[] tempString = courseArray[i].split(",");
                Course tempCourse = new Course(Integer.parseInt(tempString[0]),tempString[2]);
                tempCourse.setEcts(Integer.parseInt(tempString[4]));
                Teacher tempTeacher = new Teacher(tempString[3]);
                Class tempClass = new Class(Integer.parseInt(tempString[0]),tempString[1]);

                if(!classes.get(classes.indexOf(tempClass)).contains(tempCourse))
                {
                    classes.get(classes.indexOf(tempClass)).addCourse(tempCourse);
                }
                classes.get(classes.indexOf(tempClass)).getCourse(tempCourse).addTeacher(tempTeacher);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found or could not be opened");
        }
        // COURSES

        //ROOMS
        ArrayList<Room> rooms = new ArrayList<Room>();
        String[] roomArray=null;
        try{
            roomArray = MyFileHandler.readArrayFromTextFile("rooms.tx");
            for(int i=0;i<roomArray.length;i++)
            {
                String[] tempString = roomArray[i].split(",");
                Room tempRoom = new Room(tempString[0],Integer.parseInt(tempString[1]));
                rooms.add(tempRoom);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found or could not be opened");
        }
        //ROOMS
    }
}
