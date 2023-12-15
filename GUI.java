import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello World!"); // Komt bovenin
        Label label = new Label("Hello world!"); // Dit is een node
        Scene mainView = new Scene(label);
        stage.setScene(mainView);
        stage.show();
    }
}