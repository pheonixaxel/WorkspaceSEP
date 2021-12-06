import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ScheduleController {

    private ModelManager modelManager;

    @FXML private ChoiceBox<String> semesterChoiceSchedule;
    @FXML private ChoiceBox classChoiceSchedule;
    @FXML private ChoiceBox courseChoiceSchedule;
    @FXML private ChoiceBox teacherFirstChoiceSchedule;
    @FXML private ChoiceBox teacherSecondChoiceSchedule;
    @FXML private ChoiceBox roomChoiceSchedule;
    @FXML private DatePicker dateChoiceSchedule;
    @FXML private TextField beginHourSchedule;
    @FXML private TextField beginMinutesSchedule;
    @FXML private TextField endHourSchedule;
    @FXML private TextField endMinutesSchedule;
    @FXML private Button addButtonSchedule;
    @FXML private Button removeButtonSchedule;
    @FXML private Button goBackSchedule;
    @FXML private TextArea textAreaSchedule;

    public void init(ModelManager modelManager)
    {
        this.modelManager = modelManager;
    }
    private class Listener implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            semesterChoiceSchedule.getItems().add("Semester 1");
        }
    }
}


