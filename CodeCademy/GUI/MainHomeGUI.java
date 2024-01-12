package CodeCademy.GUI;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainHomeGUI extends SceneWrapper {

  private Button cursistBtn = new Button("Cursist open");
  private Button homeButton = new Button("aaaala");

  public MainHomeGUI(Stage stage) {
    super(stage);

    HBox hbox = new HBox(cursistBtn);
    VBox vbox = new VBox(hbox, homeButton);

    cursistBtn.setOnMouseClicked(this::openCursist);

    this.scene = new Scene(vbox);
  }

  public void openCursist(Event e) {
    GuiMain.SCENE_MANAGER.switchScene(SceneType.CURSIST);
  }

}
