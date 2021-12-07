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
      addStudent(studentsNameFieldClasses,studentsIdFieldClasses);
    }
    if(e.getSource() == removeButtonClasses)
    {
      removeStudent(studentsNameFieldClasses,studentsIdFieldClasses);
    }
    if(e.getSource() == goBackButtonClasses)
    {
      viewHandler.openView("StudentGUI");
    }
  }

  public void addStudent(TextField studentsNameFieldClasses, TextField studentsIdFieldClasses)
  {

  }
  public void removeStudent(TextField studentsNameFieldClasses,TextField studentsIdFieldClasses)
  {

  }
}
