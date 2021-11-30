import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadData
{
    public static void main(String[] args)
    {
        Class classX = new Class('X');
        Class classY = new Class('Y');
        Class classZ = new Class('Z');
        Class classDK = new Class('D');
        String[] studentsArray = null;

        try
        {
            studentsArray = MyFileHandler.readArrayFromTextFile("students.txt");
            for (int i = 0; i < studentsArray.length; i++) {
                String temp = studentsArray[i];
                String[] tempArr = temp.split(",");
                String semester = tempArr[0];
                String idChar = tempArr[1];
                int idStudent = Integer.parseInt(tempArr[2]);
                String name = tempArr[3];
                if(idChar=="X")
                {
                    classX.addStudent(new Student(name, idStudent));
                }
                else if(idChar=="Y")
                {
                    classY.addStudent(new Student(name, idStudent));
                }
                else if(idChar=="Z")
                {
                    classZ.addStudent(new Student(name, idStudent));
                }
                else if(idChar=="DK")
                {
                    classDK.addStudent(new Student(name, idStudent));
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File was not found, or could not be opened");
        }



        Course courseSDJ = new Course("SDJ");
        Course courseDMA = new Course("DMA");
        Course courseSDJ = new Course("SDJ");
        Course courseSDJ = new Course("SDJ");
    }

}
