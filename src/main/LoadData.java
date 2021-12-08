package main;

import model.Class;
import model.Student;
import model.*;
import utils.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
    public static void main(String[] args)
    {
        ClassList classList = new ClassList();
        try{
            classList = (ClassList)MyFileHandler.readFromBinaryFile("classes.bin");
        }
        catch(FileNotFoundException e){System.out.println("File not found");}
        catch(IOException e){System.out.println("IO Exception");}
        catch (ClassNotFoundException e){System.out.println("Class not found");}
        System.out.println(classList.getClass(1,"X"));
    }
}
