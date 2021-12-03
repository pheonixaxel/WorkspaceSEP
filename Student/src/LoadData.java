import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
    public static void main(String[] args) {
        Class classX = new Class('X');
        Class classY = new Class('Y');
        Class classZ = new Class('Z');
        Class classDK = new Class('D');
        String[] studentsArray = null;

        try {
            studentsArray = MyFileHandler.readArrayFromTextFile("students.txt");
            for (int i = 0; i < studentsArray.length; i++) {
                String temp = studentsArray[i];
                String[] tempArr = temp.split(",");
                String semester = tempArr[0];
                String idChar = tempArr[1];
                int idStudent = Integer.parseInt(tempArr[2]);
                String name = tempArr[3];
                if (idChar.equals("X")) {
                    classX.addStudent(new Student(name, idStudent));
                } else if (idChar.equals("Y")) {
                    classY.addStudent(new Student(name, idStudent));
                } else if (idChar.equals("Z")) {
                    classZ.addStudent(new Student(name, idStudent));
                } else if (idChar.equals("DK")) {
                    classDK.addStudent(new Student(name, idStudent));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, or could not be opened");
        }


        Course courseSDJ = new Course("SDJ");
        Course courseDMA = new Course("DMA");
        Course courseRWD = new Course("RWD");
        Course courseSEP = new Course("SEP");
        String[] courses = null;


        try {
            courses = MyFileHandler.readArrayFromTextFile("courses.txt");
            for (int i = 0; i < courses.length; i++) {
                String temp = courses[i];
                String[] tempArr = temp.split(",");
                String semester = tempArr[0];
                String idChar = tempArr[1];
                String idCourse = tempArr[2];
                String teacherInitials = tempArr[3];
                int ects = Integer.parseInt(tempArr[4]);

                if (idCourse.equals("SDJ")) {
                    courseSDJ.addTeacher(new Teacher(teacherInitials));
                    courseSDJ.setEcts(ects);
                } else if (idChar.equals("DMA")) {
                    courseDMA.addTeacher(new Teacher(teacherInitials));
                    courseDMA.setEcts(ects);
                } else if (idChar.equals("RWD")) {
                    courseRWD.addTeacher(new Teacher(teacherInitials));
                    courseRWD.setEcts(ects);
                } else if (idChar.equals("SEP")) {
                    courseSEP.addTeacher(new Teacher(teacherInitials));
                    courseSEP.setEcts(ects);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, or could not be opened");
        }
        ArrayList<Room> rooms = new ArrayList<Room>();
        String[] roomsList = new String[];
        try {
            roomsList = MyFileHandler.readArrayFromTextFile("rooms.txt");
            for (int i = 0; i < roomsList.length; i++) {
                String temp = roomsList[i];
                String[] tempArr = temp.split(",");
                String idRoom = tempArr[0];
                int size = Integer.parseInt(tempArr[1]);
                rooms.add(new Room(idRoom, size));
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file ");
        }


    }
}
