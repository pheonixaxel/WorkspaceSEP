package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ModelManager;
import model.*;

import java.io.IOException;
import java.lang.Class;
import java.util.Arrays;

public class ClassesController
{
  private Region root;

  private Stage stage;
  private Scene scene;

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

    ClassList classList = modelManager.getAllClasses();

    classChoiceClasses.setValue(classList.getClass(0).getId());

    for(int i=0;i<classList.size();i++)
    {
      classChoiceClasses.getItems().add(classList.getClass(i).getId());
    }

    /*
    TODO
    when open the listView the class should appear there
    */

    Object studNum = modelManager.getAllClasses().getClass(1,"X").getStudents().getStudent(0).getStudentNumber();

    studentsNameFieldClasses.setText(modelManager.getAllClasses().getClass(1,"X").getStudents().getStudent(0).getName());
    studentsIdFieldClasses.setText(studNum.toString());

    /*ObservableList<StudentList> studentObservableList = FXCollections.observableArrayList(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents());

    listViewClasses.setItems(studentObservableList);

    for (int i = 0; i < modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().size(); i ++)
    {
      listViewClasses.getItems().setAll((classList.getClass((Integer.parseInt(semesterChoiceClasses.getValue().toString())), classChoiceClasses.getValue().toString()).getStudents().getStudent(i)));


        listViewClasses.setItems();
    }*/

  }

  public void handleActions(ActionEvent e) throws IOException {
    if(e.getSource() == addButtonClasses)
    {
      Student tempStudent = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));

      ClassList classList = modelManager.getAllClasses();
      modelManager.addStudentToClass(tempStudent, classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
      modelManager.saveClasses(classList);

      listViewClasses.getItems().add(tempStudent.toString());

      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
    }
    else if (e.getSource() == removeButtonClasses)
    {
      Object selectedItem = listViewClasses.getSelectionModel().getSelectedItem();
      listViewClasses.getItems().remove(selectedItem);

      Student tempStudent = new Student(studentsNameFieldClasses.getText(), Integer.parseInt(studentsIdFieldClasses.getText()));

      removeStudent(tempStudent);

      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()));
/*
      System.out.println(modelManager.getAllClasses().getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().getStudent(0));
*/
    }
    else if (e.getSource() == goBackButtonClasses)
    {
      Parent root = FXMLLoader.load(getClass().getResource("StudentsGUI.fxml"));
      stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
    }
  }

  public void reset()
  {

  }
  public void updateClasses()
  {

  }

  public void addStudent(Student student)
  {
    ClassList classList = modelManager.getAllClasses();

    for (int i = 0; i < classList.size(); i ++)
    {
      if (!(student.equals(classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().getStudent(i))))
      {
        classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()),
                classChoiceClasses.getValue().toString()).addStudent(student);
      }
    }
  }

  public void removeStudent(Student student)
  {

    ClassList classList = modelManager.getAllClasses();

    for (int i = 0; i < classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().size(); i ++)
    {
        classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()),
                classChoiceClasses.getValue().toString()).removeStudent(student);
    }

    modelManager.saveClasses(classList);

    /*ClassList classList = modelManager.getAllClasses();
    ClassList classListNew = new ClassList();

    StudentList studentList = classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents();
    StudentList studentListNew = new StudentList();

    for (int i = 0; i < classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().size(); i ++)
    {
      if (!(classList.getClass(Integer.parseInt(semesterChoiceClasses.getValue().toString()), classChoiceClasses.getValue().toString()).getStudents().getStudent(i).equals(student)))
      {
        studentListNew.addStudent(studentList.getStudent(i));
      }
    }



    System.out.println();
    System.out.println();
    System.out.println(studentListNew);*/
  }

  public Region getRoot()
  {
    return root;
  }


}