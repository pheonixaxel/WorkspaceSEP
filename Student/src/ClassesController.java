import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.swing.text.View;

public class ClassesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;



  public void init(ModelManager modelManager)
  {
    this.modelManager = modelManager;
    reset();
  }

  public void reset()
  {
    if(modelManager!=null) updateClasses();
  }
  public void updateClasses()
  {

  }
}
