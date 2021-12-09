package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.ModelManager;
import model.*;

import java.util.Arrays;

public class ClassesController
{
  private Region root;
  private  ModelManager modelManager;
  //private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceClasses;
  @FXML ChoiceBox classChoiceClasses;

  @FXML TextField studentsNameFieldClasses;
  @FXML TextField studentsIdFieldClasses;

  @FXML Button addButtonClasses;
  @FXML Button removeButtonClasses;
  @FXML Button goBackButtonClasses;

  @FXML ListView listViewClasses;
/*
  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.viewHandler = viewHandler;
    this.modelManager = modelManager;
    this.root = root;
  }
*/
  public void initialize()
  {
    modelManager = new ModelManager();

    semesterChoiceClasses.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    semesterChoiceClasses.setValue("1");

    ClassList classList = modelManager.getAllClasses();

    classChoiceClasses.setValue(classList.getClass(0).getId());

    for(int i=0;i<classList.size();i++)
    {
      classChoiceClasses.getItems().add(classList.getClass(i).getId());
    }

    Object studNum = modelManager.getAllClasses().getClass(1,"X").getStudents().getStudent(0).getStudentNumber();

    studentsNameFieldClasses.setText(modelManager.getAllClasses().getClass(1,"X").getStudents().getStudent(0).getName());
    studentsIdFieldClasses.setText(studNum.toString());

  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == addButtonClasses)
    {
      Student tempStudent = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));

      ClassList classList = modelManager.getAllClasses();
      modelManager.addStudentToClass(tempStudent, classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));

      modelManager.saveClasses(classList);

      listViewClasses.getItems().add(tempStudent.toString());

      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
    }
    else if (e.getSource() == removeButtonClasses)
    {
      Object selectedItem = listViewClasses.getSelectionModel().getSelectedItem();
      listViewClasses.getItems().remove(selectedItem);

      Student tempStudent = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));

      removeStudent(tempStudent);

      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().getStudent(0));
    }
  }

  public void reset()
  {

  }
  public void updateClasses()
  {

  }

  public void removeStudent(Student student)
  {
    StudentList studentList = modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents();
    StudentList studentListNew = new StudentList();

    for (int i = 0; i < studentList.size(); i ++)
    {
      if (!(studentList.getStudent(i).equals(student)))
      {
        studentListNew.addStudent(studentList.getStudent(i));
      }
    }

    studentList = studentListNew;

    System.out.println(studentList);
    System.out.println();
    System.out.println(studentListNew);
  }

  public Region getRoot()
  {
    return root;
  }


}
