package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.Class;
import model.ModelManager;
import model.*;

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

    classChoiceClasses.getItems().addAll("X", "Y", "Z", "DK");
    classChoiceClasses.setValue("X");

  }

  public void handleActions(ActionEvent e)
  {
    if(e.getSource() == addButtonClasses)
    {
      Student tempStudent = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));
      ClassList classList = modelManager.getAllClasses();

      modelManager.addStudentToClass(tempStudent, classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
      modelManager.saveClasses(classList);

      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));

    }
    else if (e.getSource() == removeButtonClasses)
    {
      Object selectedItem = listViewClasses.getSelectionModel().getSelectedItem();
      listViewClasses.getItems().remove(selectedItem);

      Student temp = (Student) listViewClasses.getSelectionModel().getSelectedItem();

      modelManager.removeStudentFromClass(temp, modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
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
