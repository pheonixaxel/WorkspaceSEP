package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;
import model.Class;

import java.awt.event.ActionEvent;

public class CoursesController
{
  private Region root;
  private  ModelManager modelManager;
  //private ViewHandler viewHandler;

  @FXML ChoiceBox semesterChoiceCourses;
  @FXML ChoiceBox courseChoiceCourses;
  @FXML ChoiceBox classChoiceCourses;
  @FXML TextField studentsNameFieldCourses;
  @FXML TextField studentsIdFieldCourses;
  @FXML ListView listViewCourses;
  @FXML Button addButtonCourses;
  @FXML Button removeButtonCourses;
  @FXML Button goBackButtonCourses;

/*  public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root=root;
    this.viewHandler= viewHandler;
    reset();
  }*/
  public void initialize()
  {
    modelManager = new ModelManager();

    semesterChoiceCourses.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    semesterChoiceCourses.setValue("2");
    ClassList classList = modelManager.getAllClasses();
    for(int i=0;i<classList.size();i++)
    {
      classChoiceCourses.getItems().add(classList.getClass(i).getId());

      CourseList courseList = classList.getClass(i).getAllCourses();
      for(int j=0;j<courseList.size();j++)
      {
        if(!courseChoiceCourses.getItems().contains(courseList.getCourse(j).getId()))
          courseChoiceCourses.getItems().add(courseList.getCourse(j).getId());
      }
    }
  }

  public void reset()
  {
    if(modelManager!=null) updateCourses();
  }

  public void updateCourses()
  {
    listViewCourses.getItems().add(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceCourses.getValue().toString()), classChoiceCourses.getValue().toString()).toString());
  }

  public Region getRoot()
  {
    return root;
  }


    public void handle(ActionEvent e)
    {
      if(e.getSource()==addButtonCourses)
      {
        updateCourses();
        addStudent();
      }
      if(e.getSource()== removeButtonCourses)
      {
        removeStudent();
      }
      if(e.getSource()==goBackButtonCourses)
      {
   //     viewHandler.openView("StudentGUI");
      }
    }

    public void addStudent()
    {
      Student student = new Student(studentsNameFieldCourses.getText(), Integer.parseInt(studentsIdFieldCourses.getText()));
/*
      StudentList studentList = modelManager.getClass(Integer.parseInt(semesterChoiceCourses.getValue().toString()), classChoiceCourses.getValue().toString());
*/
      StudentList studentList = modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceCourses.getValue().toString()), classChoiceCourses.getValue().toString()).getStudents();
      modelManager.addStudent(student, studentList);
    }
    public void removeStudent()
    {
      Student student = new Student(studentsNameFieldCourses.getText(), Integer.parseInt(studentsIdFieldCourses.getText()));

      StudentList studentList = modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceCourses.getValue().toString()), classChoiceCourses.getValue().toString()).getStudents();


      modelManager.removeStudent(student, studentList);
    }


  }

