package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.ModelManager;

public class ClassesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceClasses;


  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.viewHandler = viewHandler;
    this.modelManager = modelManager;
    this.root = root;
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

  public void handleActions(ActionEvent e)
  {
    //if(e.getSource() == )
  }
}
