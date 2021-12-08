package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

import java.awt.event.ActionEvent;

public class CoursesController
{
  private Region root;
  private  ModelManager modelManager;
  //private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceCourses;
  @FXML ChoiceBox courseChoiceCourses;
  @FXML TextField studentsNameFieldCourses;
  @FXML TextField studentsIdFieldCourses;
  @FXML Button addButtonCourses;
  @FXML Button removeButtonCourses;
  @FXML Button goBackButtonCourses;

  /*public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root=root;
    this.viewHandler= viewHandler;
    reset();
  }
*/
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


    public void handle(ActionEvent e)
    {
      if(e.getSource()==addButtonCourses)
      {
        addStudent(studentsNameFieldCourses,studentsIdFieldCourses);
      }
      if(e.getSource()== removeButtonCourses)
      {
        removeStudent(studentsNameFieldCourses,studentsIdFieldCourses);
      }
      if(e.getSource()==goBackButtonCourses)
      {
   //     viewHandler.openView("StudentGUI");
      }
    }

    public void addStudent(TextField studentsNameFieldCourses, TextField studentsIdFieldCourses)
    {

    }
    public void removeStudent(TextField studentsNameFieldCourses, TextField studentsIdFieldCourses)
    {

    }
  }

