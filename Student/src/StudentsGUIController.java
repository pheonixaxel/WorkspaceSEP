import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javax.swing.text.View;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public class StudentsGUIController
{
    private Region root;
    private ModelManager modelManager;
    private ViewHandler viewHandler;



    @FXML Button classesButtonMain;
    @FXML Button coursesButtonMain;
    @FXML Button scheduleButtonMain;


    public void init(ViewHandler viewHandler, ModelManager modelManager, Region root)
    {
        this.modelManager = modelManager;
        this.root = root;
        this.viewHandler = viewHandler;
    }

    public void reset()
    {

    }

    public Region getRoot()
    {
        return root;
    }

    public void handleActions(ActionEvent e)
    {
        if(e.getSource() == classesButtonMain)
        {
            viewHandler.openView("StudentsGUI");
        }
        else if(e.getSource() == classesButtonMain)
        {
            viewHandler.openView("Classes");
        }
        else if(e.getSource() == coursesButtonMain)
        {
            viewHandler.openView("Courses");
        }
        else if(e.getSource() == scheduleButtonMain)
        {
            viewHandler.openView("Schedule");
        }
    }

}
