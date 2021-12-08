package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ModelManager;
import model.Class;
import model.*;

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

  /*public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.viewHandler = viewHandler;
    this.modelManager = modelManager;
    this.root = root;
  }*/

  public void initialize()
  {
    modelManager = new ModelManager();
    ClassList classList = modelManager.getAllClasses();
    semesterChoiceClasses.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    for(int i=0;i<classList.size();i++)
    {
      classChoiceClasses.getItems().add(classList.getClass(i).getId());
    }
  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == addButtonClasses)
    {
      Student student = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));

      modelManager.addStudentToClass(student, modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
    }
  }

  public void reset()
  {

  }
  public void updateClasses()
  {

  }

  public Region getRoot()
  {
    return root;
  }


}
