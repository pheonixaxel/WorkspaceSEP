import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
    private Scene scene;
    private Stage window;
    private StudentsGUIController studentsGUIController;
    private CoursesController coursesController;
    private ClassesController classesController;
    private ScheduleController scheduleController;


    private ModelManager modelManager;

    public ViewHandler(ModelManager modelManager) throws IOException
    {
        this.modelManager = modelManager;
        scene = new Scene(new Region());
    }

    public void start(Stage window)
    {
        this.window= window;
        openView("StudentsGUI");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "StudentsGUI":
                root = loadStudentsGUI();
                break;
            case "Courses":
                root = loadCoursesView();
                break;
            case "Classes":
                root = loadClassesView();
                break;
            case "Schedule":
                root = loadScheduleView();
                break;
        }
        scene.setRoot(root);
        String title = "";

        if(root.getUserData() !=null)
        {
            title += root.getUserData();
        }

        window.setTitle(title);
        window.setScene(scene);
        window.setWidth(root.getPrefWidth());
        window.setHeight(root.getPrefHeight());
        window.show();
    }

    private Region loadStudentsGUI()
    {
        if(studentsGUIController != null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("StudentsGUI.fxml"));
                Region root = loader.load();
                studentsGUIController = loader.getController();
                studentsGUIController.init(this, modelManager, root);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            studentsGUIController.reset();
        }
        return studentsGUIController.getRoot();
    }

    private Region loadCoursesView()
    {
        if(coursesController == null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Courses.fxml"));
                Region root = loader.load();
                coursesController = loader.getController();
                coursesController.init(this, modelManager, root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            coursesController.reset();
        }

        return coursesController.getRoot();
    }

    private Region loadClassesView()
    {
        if(classesController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Classes.fxml"));
                Region root = loader.load();
                classesController = loader.getController();
                classesController.init(this, modelManager, root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            classesController.reset();
        }

        return classesController.getRoot();
    }

    private Region loadScheduleView()
    {
        if(classesController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Schedule.fxml"));
                Region root = loader.load();
                scheduleController = loader.getController();
                scheduleController.init(this, modelManager, root);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            scheduleController.reset();
        }

        return scheduleController.getRoot();
    }


}
