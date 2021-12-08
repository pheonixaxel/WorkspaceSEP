package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.*;

import java.awt.event.ActionEvent;

public class CoursesController
{
  private Region root;
  private  ModelManager modelManager;
  private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceCourses;
  @FXML ChoiceBox courseChoiceCourses;
  @FXML ChoiceBox classChoiceCourses;
  @FXML TextField studentsNameFieldCourses;
  @FXML TextField studentsIdFieldCourses;
  @FXML Button addButtonCourses;
  @FXML Button removeButtonCourses;
  @FXML Button goBackButtonCourses;
  @FXML ListView listViewCourses;

  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root=root;
    this.viewHandler= viewHandler;
    reset();
  }
  public void initialize()
  {
    modelManager = new ModelManager();
    ClassList classList = modelManager.getAllClasses();
    semesterChoiceCourses.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    for(int i=0;i<classList.size();i++)
    {
      classChoiceCourses.getItems().add(classList.getClass(i).getId());

      CourseList courseList = classList.getClass(i).getAllCourses();
      for(int j=0;j<courseList.size();j++)
      {
        if (!courseChoiceCourses.getItems().contains(courseList.getCourse(j).getId()))
        {
          courseChoiceCourses.getItems().add(courseList.getCourse(j).getId());
        }
      }
    }
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
        viewHandler.openView("StudentGUI");
      }
    }

    public void addStudent(TextField studentsNameFieldCourses, TextField studentsIdFieldCourses)
    {

    }
    public void removeStudent(TextField studentsNameFieldCourses, TextField studentsIdFieldCourses)
    {

    }
  }

