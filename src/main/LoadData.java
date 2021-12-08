package main;

import model.Class;
import model.Student;
import model.*;
import utils.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadData {
    public static void main(String[] args)
    {
        ClassList classList = new ClassList();
        RoomList roomList = new RoomList();

        // students.txt
        try{
            String[] studentArray = MyFileHandler.readArrayFromTextFile("students.txt");
            for(int i=0;i<studentArray.length;i++)
            {
                String[] tempString = studentArray[i].split(",");
                int semester = Integer.parseInt(tempString[0]);
                String id = tempString[1];
                int studentNumber = Integer.parseInt(tempString[2]);
                String name = tempString[3];

                if(classList.getClass(semester,id)==null)
                    classList.addClass(new Class(semester,id));
                classList.getClass(semester,id).addStudent(new Student(name,studentNumber));
            }
        }
        catch(FileNotFoundException e){System.out.println("File was not found");}

        // courses.txt
        try{
            String[] courseArray = MyFileHandler.readArrayFromTextFile("courses.txt");
            for(int i=0;i<courseArray.length;i++)
            {
                String[] tempString = courseArray[i].split(",");
                int semester = Integer.parseInt(tempString[0]);
                String classId = tempString[1];
                String courseId = tempString[2];
                String name = tempString[3];
                int ects = Integer.parseInt(tempString[4]);
                if(classList.getClass(semester,classId)==null)
                    classList.addClass(new Class(semester,classId));
                if(classList.getClass(semester,classId).getCourse(courseId)==null)
                    classList.getClass(semester,classId).addCourse(new Course(semester,courseId));
                classList.getClass(semester,classId).getCourse(courseId).addTeacher(new Teacher(name));
                classList.getClass(semester,classId).getCourse(courseId).setEcts(ects);
            }
        }
        catch(FileNotFoundException e){System.out.println("File was not found");}

        // rooms.txt
        try{
            String[] roomArray = MyFileHandler.readArrayFromTextFile("rooms.txt");
            for(int i=0;i<roomArray.length;i++)
            {
                String[] tempString = roomArray[i].split(",");
                String id = tempString[0];
                int size = Integer.parseInt(tempString[1]);
                roomList.addRoom(new Room(id,size));
            }
        }
        catch (FileNotFoundException e){System.out.println("File was not found");}


        try{
            MyFileHandler.writeToBinaryFile("classes.bin",classList);
        }
        catch(FileNotFoundException e){System.out.println("File was not found");}
        catch(IOException e){System.out.println(e.getMessage());}

        try{
            MyFileHandler.writeToBinaryFile("rooms.bin",roomList);
        }
        catch(FileNotFoundException e){System.out.println("File was not found");}
        catch(IOException e){System.out.println(e.getMessage());}

        System.out.println("Done!");
    }
}
