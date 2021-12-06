import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application
{
        public void start(Stage window) throws Exception
        {
            ModelManager modelManager = new ModelManager("students.txt");
            ViewHandler viewHandler = new ViewHandler(modelManager);
            viewHandler.start(window);

        }
}
