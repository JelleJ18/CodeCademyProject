package CodeCademy.GUI;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainHomeGUI extends SceneWrapper {

  private Button cursistBtn = new Button("Cursist");
  private Button cursusBtn = new Button("Cursus");
  private Button certificaatBtn = new Button("Certificaat");
  private Button homeButton = new Button("Home");

  public MainHomeGUI(Stage stage) {
    super(stage);

    HBox hbox = new HBox(cursistBtn, cursusBtn, certificaatBtn);
    VBox vbox = new VBox(hbox, homeButton);

    cursistBtn.setOnAction(this::openCursist);
    cursusBtn.setOnAction(this::openCursus);
    certificaatBtn.setOnAction(this::openCertificaat);

    this.scene = new Scene(vbox);

    // Voeg eventueel stijlen toe
    cursistBtn.setStyle("-fx-font-size: 14;");
    cursusBtn.setStyle("-fx-font-size: 14;");
    certificaatBtn.setStyle("-fx-font-size: 14;");
    homeButton.setStyle("-fx-font-size: 14;");
  }

  private void openCursist(ActionEvent event) {
    GuiMain.SCENE_MANAGER.switchScene(SceneType.CURSIST);
  }

  private void openCursus(ActionEvent event) {
    GuiMain.SCENE_MANAGER.switchScene(SceneType.CURSUS);
  }

  private void openCertificaat(ActionEvent event) {
    GuiMain.SCENE_MANAGER.switchScene(SceneType.CERTIFICAAT);
  }
}