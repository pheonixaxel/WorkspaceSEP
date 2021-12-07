import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CoursesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceClasses;
  @FXML ChoiceBox courseChoiceClasses;
  @FXML TextField studentsNameFieldClasses;
  @FXML TextField studentsIdFieldClasses;
  @FXML Button addButtonClasses;
  @FXML Button removeButtonClasses;
  @FXML Button goBackButtonClasses;

  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root=root;
    this.viewHandler= viewHandler;
    reset();
  }

  public void reset()
  {
    if(modelManager!=null) updateCourses();
  }

  public void updateCourses()
  {

  }

  public Region getRoot()
  {
    return root;
  }

}
