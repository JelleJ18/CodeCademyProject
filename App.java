import java.sql.*;

import javafx.application.Application;

public class App {

  public static void main(String[] args) {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // link
      String connectionUrl = "jdbc:sqlserver://aei-sql2.avans.nl:1443;encrypt=true;databaseName=DatabaseNaam;user=usernaam;password=wachtwoord;trustServerCertificate=true";
      String username = "usernaam";
      String password = "wachtwoord";

      // zorgt voor een connectie
      Connection connection = DriverManager.getConnection(connectionUrl, username, password);
      System.out.println("Connected!");
      String query = "SELECT * FROM cursist";
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()) {
        String name = rs.getString("naam");
        System.out.println(name);
      }

    } catch (Exception e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
    Application.launch(GUI.class);
  }
}