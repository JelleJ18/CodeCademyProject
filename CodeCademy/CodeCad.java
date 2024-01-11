package CodeCademy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import CodeCademy.GUI.*;
import javafx.application.Application;

public class CodeCad {
  public static Connection connection;

  public static void main(String[] args) {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // link
      String connectionUrl = "jdbc:sqlserver://aei-sql2.avans.nl:1443;encrypt=true;databaseName=DatabaseNaam;user=usernaam;password=wachtwoord;trustServerCertificate=true";
      String username = "usernaam";
      String password = "wachtwoord";

      // zorgt voor een connectie
      connection = DriverManager.getConnection(connectionUrl, username, password);
      System.out.println("Connected!");
    } catch (Exception e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
    Application.launch(CursistCreationGUI.class);
  }

  public static List<String> getNames() {
    ArrayList<String> list = new ArrayList<>();
    try {
      String query = "SELECT * FROM cursist";
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery(query);
      while (rs.next()) {
        String name = rs.getString("naam");
        list.add(name);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return list;
  }

}
