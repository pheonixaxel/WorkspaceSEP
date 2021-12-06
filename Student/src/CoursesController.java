import javafx.scene.layout.Region;

public class CoursesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;



  public void init(ModelManager modelManager)
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
