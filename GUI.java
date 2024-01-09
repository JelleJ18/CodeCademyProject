import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene mainView = new Scene(root, Color.BLACK);

        Image icon = new Image("icon.jpg");
        stage.getIcons().add(icon);
        stage.setTitle("CodeCademy Application");
        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Click escape to escape!");

        stage.setScene(mainView);
        stage.show();
    }
}
