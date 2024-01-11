package CodeCademy.Database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import CodeCademy.*;
import CodeCademy.Contents.Cursist;
import CodeCademy.Contents.Webcast;
import CodeCademy.GUI.CursistGUI;
import javafx.application.Application;

public class App {
  private static Connection connection = CodeCad.connection;

  public static void main(String[] args) {

  }

  public static void createCursist(Cursist cursist) {
    try {
      PreparedStatement insertStatement = connection.prepareStatement(
          "INSERT INTO Cursist(naam, email, dateOfBirth, gender, address, hometown, country)\n" +
              "VALUES(?, ?, ?, ?, ?, ?, ?)");
      insertStatement.setString(1, cursist.nameProperty().get());
      insertStatement.setString(2, cursist.emailProperty().get());
      LocalDate dateOfString = cursist.dateOfBirthProperty().get();
      java.sql.Date sqlDate = java.sql.Date.valueOf(dateOfString);
      insertStatement.setDate(3, sqlDate);
      insertStatement.setString(4, cursist.genderProperty().get());
      insertStatement.setString(5, cursist.addressProperty().get());
      insertStatement.setString(6, cursist.hometownProperty().get());
      insertStatement.setString(7, cursist.countryProperty().get());

      insertStatement.executeQuery();
    } catch (SQLException e) {
      // Handle SQL exceptions, including duplicate primary key errors
      if (e.getSQLState().equals("23505")) {
        System.out.println("Duplicate primary key");
      } else {
        e.printStackTrace();
      }
    }

  }

  public static List<Cursist> getCursist(int offset) {

    ArrayList<Cursist> list = new ArrayList<>();

    try {
      PreparedStatement selectCursist = connection.prepareStatement(
          "SELECT * FROM Cursist ORDER BY naam OFFSET ? ROWS FETCH NEXT 100 ROWS ONLY");

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
