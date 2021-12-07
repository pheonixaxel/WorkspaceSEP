import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.util.ArrayList;

public class ClassesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceClasses;
  @FXML ChoiceBox classChoiceClasses;
  @FXML TextField studentsNameFieldClasses;
  @FXML TextField studentsIdFieldClasses;
  @FXML Button addButtonClasses;
  @FXML Button removeButtonClasses;
  @FXML Button goBackButtonClasses;

  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.viewHandler = viewHandler;
    this.modelManager = modelManager;
    this.root = root;
    reset();
  }

  public void reset()
  {
    if(modelManager!=null) updateClasses();
  }

  public void updateClasses()
  {

  }

  public Region getRoot()
  {
    return root;
  }
  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == addButtonClasses)
    {
      ArrayList<Class> classes = modelManager.getAllClasses();
      StudentList studentList = new StudentList();
      for(int i=0;i<classes.size();i++)
      {
        if(classes.get(i).getId().equals(classChoiceClasses.getSelectionModel().getSelectedItem().toString()) && classes.get(i).getSemester() == Integer.parseInt(semesterChoiceClasses.getSelectionModel().getSelectedItem().toString()))
        studentList = classes.get(i).getStudents();
      }
      modelManager.addStudent(new Student(studentsNameFieldClasses.getText(),Integer.parseInt(studentsIdFieldClasses.getText())), studentList);
    }
    if(e.getSource() == removeButtonClasses)
    {
      ArrayList<Class> classes = modelManager.getAllClasses();
      StudentList studentList = new StudentList();
      for(int i=0;i<classes.size();i++)
      {
        if(classes.get(i).getId().equals(classChoiceClasses.getSelectionModel().getSelectedItem().toString()) && classes.get(i).getSemester() == Integer.parseInt(semesterChoiceClasses.getSelectionModel().getSelectedItem().toString()))
          studentList = classes.get(i).getStudents();
      }
      modelManager.removeStudent(new Student(studentsNameFieldClasses.getText(),Integer.parseInt(studentsIdFieldClasses.getText())), studentList);
    }
    if(e.getSource() == goBackButtonClasses)
    {
      viewHandler.openView("StudentGUI");
    }
  }
}
