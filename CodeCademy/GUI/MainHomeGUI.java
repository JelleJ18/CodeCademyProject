package CodeCademy.GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainHomeGUI extends SceneWrapper {

  private Button cursistBtn = new Button("Cursist");
  public Scene mainview;

  public MainHomeGUI(Stage stage) {
    super(stage);
    stage.setTitle("CodeCademy Application");
    mainview = new Scene(cursistBtn);
    stage.setScene(mainview);
    stage.setFullScreen(true);
    stage.show();
  }

}
