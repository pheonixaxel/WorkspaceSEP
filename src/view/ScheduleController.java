package view;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import model.*;

public class ScheduleController {

  private ViewHandler viewHandler;
  private Region root;
  private ModelManager modelManager;

  @FXML private Button addButtonSchedule;
  @FXML private Button removeButtonSchedule;
  @FXML private Button goBackSchedule;

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
  @FXML private TextArea textAreaSchedule;

  public void initialize(ViewHandler viewHandler, ModelManager modelManager, Region root)
  {
    this.modelManager = modelManager;
    this.root = root;
    this.viewHandler = viewHandler;
  }

  public void initialize()
  {
    modelManager = new ModelManager();
    semesterChoiceSchedule.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
    classChoiceSchedule.getItems().addAll("X", "Y", "Z", "DK");
    courseChoiceSchedule.getItems().addAll("SDJ", "DMA", "RWD", "SEP");
    teacherFirstChoiceSchedule.getItems().addAll("ALHE", "SVA", "KLAB", "MIVI", "AHAN", "MWA");
    teacherSecondChoiceSchedule.getItems().addAll("ALHE", "SVA", "KLAB", "MIVI", "AHAN", "MWA");
    roomChoiceSchedule.getItems().addAll("C05.15,45", "C05.16a,45", "C05.16b,45", "C03.12,20", "C03.13,125");
  }

  public void handleActions(ActionEvent e)
  {
    if (e.getSource() == addButtonSchedule)
    {
      System.out.println("clicked!");

      String value = "";
      value += (String) semesterChoiceSchedule.getValue() + ", " + classChoiceSchedule.getValue() + ", " + courseChoiceSchedule.getValue()
              + ", " + teacherFirstChoiceSchedule.getValue() + ", " + teacherSecondChoiceSchedule.getValue()
              + ", " + roomChoiceSchedule.getValue() + ", " + dateChoiceSchedule.getValue() + ", " + beginHourSchedule.getText() + " : " + beginMinutesSchedule.getText()
              + ", " + endHourSchedule.getText() + " : " + endMinutesSchedule.getText() + "\n";

      textAreaSchedule.appendText(value);
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

    modelManager.addLesson(lesson);
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
    textAreaSchedule.setText("");
    beginHourSchedule.setText("");
  }
  
  public void reset()
  {
    
  }


  public Region getRoot() {
    return root;
  }
}
