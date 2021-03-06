package view;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import javafx.stage.Stage;
import model.*;
import model.Lesson;
import model.Class;
import util.*;

import javax.swing.*;
import java.io.IOException;

public class ScheduleController {
    private ModelManager modelManager;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button addButtonSchedule;
    @FXML
    private Button removeButtonSchedule;
    @FXML
    private Button goBackSchedule;
    @FXML
    private Button refreshButtonSchedule;

    @FXML
    private ListView listViewSchedule;

    @FXML
    private ChoiceBox semesterChoiceSchedule;
    @FXML
    private ChoiceBox classChoiceSchedule;
    @FXML
    private ChoiceBox courseChoiceSchedule;
    @FXML
    private ChoiceBox teacherFirstChoiceSchedule;
    @FXML
    private ChoiceBox teacherSecondChoiceSchedule;
    @FXML
    private ChoiceBox roomChoiceSchedule;
    @FXML
    private DatePicker dateChoiceSchedule;
    @FXML
    private TextField beginMinutesSchedule;
    @FXML
    private TextField endHourSchedule;
    @FXML
    private TextField beginHourSchedule;
    @FXML
    private TextField endMinutesSchedule;

    public void initialize() {
        modelManager = new ModelManager();
        semesterChoiceSchedule.getItems().addAll("1", "2", "3", "4", "5", "6", "7");
        ClassList classList = modelManager.getAllClasses();
        for (int i = 0; i < classList.size(); i++) {
            classChoiceSchedule.getItems().add(classList.getClass(i).getId());

            CourseList courseList = classList.getClass(i).getAllCourses();
            for (int j = 0; j < courseList.size(); j++) {
                if (!courseChoiceSchedule.getItems().contains(courseList.getCourse(j).getId())) {
                    courseChoiceSchedule.getItems().add(courseList.getCourse(j).getId());
                }

                TeacherList teacherList = courseList.getCourse(j).getAllTeachers();
                for (int k = 0; k < teacherList.size(); k++) {
                    //System.out.println(teacherList.getTeacher(k).getInitials());
                    if (!teacherFirstChoiceSchedule.getItems().contains(teacherList.getTeacher(k).getInitials())) {
                        teacherFirstChoiceSchedule.getItems().add(teacherList.getTeacher(k).getInitials());
                    }
                    if (!teacherSecondChoiceSchedule.getItems().contains(teacherList.getTeacher(k).getInitials())) {
                        teacherSecondChoiceSchedule.getItems().add(teacherList.getTeacher(k).getInitials());
                    }
                }
            }
        }
        RoomList roomList = modelManager.getAllRooms();
        for (int i = 0; i < roomList.size(); i++) {
            roomChoiceSchedule.getItems().add(roomList.getRoom(i).getId());
        }
    }

    public void handleActions(ActionEvent e) throws IOException {
        if (e.getSource() == addButtonSchedule) {
            System.out.println("clicked!");
            addLesson();
        } else if (e.getSource() == removeButtonSchedule) {
            removeLesson();
        } else if (e.getSource() == goBackSchedule) {
            System.out.println("clicked!");

            Parent root = FXMLLoader.load(getClass().getResource("StudentsGUI.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (e.getSource() == refreshButtonSchedule) {
            updateListView();
        }
    }

    public void updateListView() {
        System.out.println("IT IS CALLED");
        listViewSchedule.getItems().clear();
        String filePath = "schedule" + semesterChoiceSchedule.getValue().toString() + classChoiceSchedule.getValue().toString() + ".bin";
        Schedule schedule = modelManager.getScheduleFromFile(filePath);
        for (int i = 0; i < schedule.size(); i++) {
            listViewSchedule.getItems().add(schedule.getLesson(i));
            System.out.println(schedule.getLesson(i));
        }
    }

    public void addLesson() {
        ClassList classList = modelManager.getAllClasses();
        RoomList roomList = modelManager.getAllRooms();
        Lesson lesson = new Lesson(new Clock(Integer.parseInt(beginHourSchedule.getText()), Integer.parseInt(beginMinutesSchedule.getText())),
                new Date(dateChoiceSchedule.getValue().getDayOfMonth(), dateChoiceSchedule.getValue().getMonthValue(), dateChoiceSchedule.getValue().getYear()),
                new Clock(Integer.parseInt(endHourSchedule.getText()), Integer.parseInt(endMinutesSchedule.getText())),
                new Course(Integer.parseInt((String) semesterChoiceSchedule.getValue()), courseChoiceSchedule.getValue().toString()),
                classList.getClass(Integer.parseInt(semesterChoiceSchedule.getValue().toString()), classChoiceSchedule.getValue().toString()).getCourse(courseChoiceSchedule.getValue().toString()).getAllTeachers().getTeacher(teacherFirstChoiceSchedule.getValue().toString()),
                roomList.getRoom(roomChoiceSchedule.getValue().toString()));

        modelManager.addLesson(lesson, classList.getClass(Integer.parseInt(semesterChoiceSchedule.getValue().toString()), classChoiceSchedule.getValue().toString()));

        modelManager.saveSchedule(classList.getClass(Integer.parseInt(semesterChoiceSchedule.getValue().toString()), classChoiceSchedule.getValue().toString()));

        modelManager.saveClasses(classList);

        updateListView();
    }

    public void removeLesson() {/*
    ClassList classList = modelManager.getAllClasses();
    System.out.println(listViewSchedule.getSelectionModel().getSelectedItem());
    Lesson lesson =(Lesson)listViewSchedule.getSelectionModel().getSelectedItem();
    int semester = Integer.parseInt(semesterChoiceSchedule.getValue().toString());
    String id =
    classList.getClass().*/
    }

    public void clearFields() {
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

    public void reset() {

    }
}
