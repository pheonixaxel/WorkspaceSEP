package view;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import model.*;
import model.Lesson;
import model.Class;
import util.*;

import javax.swing.*;

public class ScheduleController {
  private Region root;
  private ModelManager modelManager;

  @FXML private Button addButtonSchedule;
  @FXML private Button removeButtonSchedule;
  @FXML private Button goBackSchedule;

  @FXML private ListView listViewSchedule;

  @FXML private ChoiceBox semesterChoiceSchedule;
  @FXML private ChoiceBox classChoiceSchedule;
  @FXML private ChoiceBox courseChoiceSchedule;
  @FXML private ChoiceBox teacherFirstChoiceSchedule;
  @FXML private ChoiceBox teacherSecondChoiceSchedule;
  @FXML private ChoiceBox roomChoiceSchedule;
  @FXML private DatePicker dateChoiceSchedule;
  @FXML private TextField beginMinutesSchedule;
  @FXML private TextField endHourSchedule;
  @FXML private TextField beginHourSchedule;
  @FXML private TextField endMinutesSchedule;

  public void initialize()
  {
    modelManager = new ModelManager();
    semesterChoiceSchedule.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    ClassList classList = modelManager.getAllClasses();
    for(int i=0;i<classList.size();i++)
    {
      classChoiceSchedule.getItems().add(classList.getClass(i).getId());

      CourseList courseList = classList.getClass(i).getAllCourses();
      for(int j=0;j<courseList.size();j++)
      {
        if(!courseChoiceSchedule.getItems().contains(courseList.getCourse(j).getId()))
        {
          courseChoiceSchedule.getItems().add(courseList.getCourse(j).getId());
        }

        TeacherList teacherList = courseList.getCourse(j).getAllTeachers();
        for(int k=0;k<teacherList.size();k++)
        {
          //System.out.println(teacherList.getTeacher(k).getInitials());
          if(!teacherFirstChoiceSchedule.getItems().contains(teacherList.getTeacher(k).getInitials()))
          {
            teacherFirstChoiceSchedule.getItems().add(teacherList.getTeacher(k).getInitials());
          }
          if(!teacherSecondChoiceSchedule.getItems().contains(teacherList.getTeacher(k).getInitials()))
          {
            teacherSecondChoiceSchedule.getItems().add(teacherList.getTeacher(k).getInitials());
          }
        }
      }
    }
    RoomList roomList = modelManager.getAllRooms();
    for(int i=0;i<roomList.size();i++)
    {
      roomChoiceSchedule.getItems().add(roomList.getRoom(i).getId());
    }
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addButtonSchedule)
    {
      System.out.println("clicked!");

      String value = "";
      value += semesterChoiceSchedule.getValue() + ", " + classChoiceSchedule.getValue() + ", " + courseChoiceSchedule.getValue()
              + ", " + teacherFirstChoiceSchedule.getValue() + ", " + teacherSecondChoiceSchedule.getValue()
              + ", " + roomChoiceSchedule.getValue() + ", " + dateChoiceSchedule.getValue() + ", " + beginHourSchedule.getText() + " : " + beginMinutesSchedule.getText()
              + ", " + endHourSchedule.getText() + " : " + endMinutesSchedule.getText() + "\n";

      listViewSchedule.getItems().addAll(value);
      addLesson();
    }

    else if (e.getSource() == removeButtonSchedule)
    {
      System.out.println("clicked!");
      clearFields();
    }

    else if (e.getSource() == goBackSchedule)
    {
      System.out.println("clicked!");
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Bro... u got an ERROR");
      alert.setHeaderText("You wanna go back??");
      alert.setContentText("Go back where u lazy MF!? Go work and do the other pages! fking cunt...");

      alert.showAndWait();
    }
  }

  public void addLesson()
  {
    Lesson lesson = new Lesson(new Clock(Integer.parseInt(beginHourSchedule.getText()), Integer.parseInt(beginMinutesSchedule.getText())),
            new Date(dateChoiceSchedule.getValue().getDayOfMonth(), dateChoiceSchedule.getValue().getMonthValue(), dateChoiceSchedule.getValue().getYear()),
            new Clock(Integer.parseInt(endHourSchedule.getText()), Integer.parseInt(endMinutesSchedule.getText())),
            new Course(Integer.parseInt((String) semesterChoiceSchedule.getValue()), courseChoiceSchedule.getValue().toString()));

    //modelManager.addLesson(lesson);
    System.out.println(lesson);
  }

  public void clearFields()
  {
    semesterChoiceSchedule.setValue(null);
    classChoiceSchedule.setValue(null);
    courseChoiceSchedule.setValue(null);
    teacherFirstChoiceSchedule.setValue(null);
    teacherSecondChoiceSchedule.setValue(null);
    roomChoiceSchedule.setValue(null);
    dateChoiceSchedule.setValue(null);
    beginMinutesSchedule.setText("");
    endHourSchedule.setText("");
    endMinutesSchedule.setText("");
    beginHourSchedule.setText("");
  }

  public void reset()
  {

  }


  public Region getRoot() {
    return root;
  }
}
