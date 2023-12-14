import java.sql.*;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class App {
  public static void main(String[] args) {
    try {
      DriverManager.setLoginTimeout(20);
      Database.connect(DriverManager
          .getConnection("jdbc:sqlserver://localhost:1443;databaseName=DatabaseNaam;encrypt=true;", "usernaam",
              "wachtwoord"));
    } catch (SQLException e) {
      new Alert(Alert.AlertType.ERROR, "Failed to connect to the database. Try again later.\n" + e.getMessage(),
          ButtonType.CLOSE).show();
    }
  }
}