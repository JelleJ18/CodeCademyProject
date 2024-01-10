package CodeCademy.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import CodeCademy.*;
import CodeCademy.Contents.Cursist;
import CodeCademy.Contents.Webcast;
import CodeCademy.GUI.WebcastGUI;
import javafx.application.Application;

public class App {
  private static Connection connection = CodeCad.connection;

  public static void main(String[] args) {

  }

  public static List<Cursist> getCursist(int offset) {

    ArrayList<Cursist> list = new ArrayList<>();

    try {
      PreparedStatement selectCursist = connection.prepareStatement(
          "SELECT * FROM Cursist ORDER BY naam OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY");

      selectCursist.setInt(1, offset);

      ResultSet rs = selectCursist.executeQuery();

      while (rs.next()) {
        list.add(new Cursist(
            rs.getString("naam"),
            rs.getString("email"),
            rs.getDate("dateOfBirth").toLocalDate(),
            rs.getString("gender"),
            rs.getString("address"),
            rs.getString("hometown"),
            rs.getString("country")));
      }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return list;
  }

  public static List<Cursist> getCursist() {
    return getCursist(0);
  }

}
