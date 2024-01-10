package CodeCademy.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

public class MainHomeGUI extends Application {

  private Button cursistBtn = new Button("Cursist");
  public Scene mainview;

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("CodeCademy Application");
    mainview = new Scene(cursistBtn);
    stage.setScene(mainview);
    stage.setFullScreen(true);
    stage.show();
  }

}
