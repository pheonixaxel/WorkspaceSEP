package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGUI extends Application
{
    public void start(Stage window) throws Exception
    {
        window.setTitle("SEP");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../StudentsGUI.fxml"));
        Scene scene = new Scene(loader.load());
        window.setResizable(false);
        window.setScene(scene);
        window.show();
    }
}
