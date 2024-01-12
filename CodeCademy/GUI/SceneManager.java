package CodeCademy.GUI;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SceneManager {
  private final SceneType splash = SceneType.HOME;

  private HashMap<SceneType, SceneWrapper> scenes;
  private Stage mainStage;
  private SceneType currentScene = splash;

  public SceneManager(Stage mainStage) {
    this.mainStage = mainStage;

    this.scenes = new HashMap<>(Map.ofEntries(
        Map.entry(SceneType.HOME, new MainHomeGUI(mainStage)),
        Map.entry(SceneType.CURSIST, new CursistGUI(mainStage))));

    this.scenes.get(splash).show();
  }

  public void switchScene(SceneType scene) {
    System.out.println("Switching");
    this.scenes.get(scene).show();
    this.currentScene = scene;
  }

  public static void showErrorDialog(String message) {
    new Alert(Alert.AlertType.ERROR, message, ButtonType.CLOSE).show();
  }

  public SceneWrapper getCurrentScene() {
    return this.scenes.get(currentScene);
  }
}
