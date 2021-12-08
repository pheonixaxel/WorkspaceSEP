package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.ModelManager;
import javafx.scene.Node;

import java.io.IOException;

public class StudentsGUIController
{
    private Region root1;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private ModelManager modelManager;




    @FXML Button classesButtonMain;
    @FXML Button coursesButtonMain;
    @FXML Button scheduleButtonMain;


 /*   public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
    {
        this.modelManager = modelManager;
        this.root = root;
        this.viewHandler = viewHandler;
    }*/

    public void reset()
    {

    }

    public Region getRoot()
    {
        return root1;
    }

    public void handleActions(ActionEvent event) throws IOException {
        if (event.getSource() == scheduleButtonMain) {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Schedule.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if (event.getSource() == classesButtonMain)
        {
            Parent root = FXMLLoader.load(getClass().getResource("Classes.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    /*
    public void handleActions(ActionEvent e)
    {
        *//*if(e.getSource() == classesButtonMain)
        {
            viewHandler.openView("StudentsGUI");
        }*//*
        if(e.getSource() == classesButtonMain)
        {
            viewHandler.openView("Classes.fxml");
        }
        else if(e.getSource() == coursesButtonMain)
        {
            viewHandler.openView("Courses.fxml");
        }
        else if(e.getSource() == scheduleButtonMain)
        {
            System.out.println("clicked!!!");
            viewHandler.openView("Schedule.fxml");
        }
    }
    */

}
