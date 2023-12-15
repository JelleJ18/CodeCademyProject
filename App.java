import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
  public static void main(String[] args) {
    String dburl = "jdbc:sqlserver://aei-sql2.avans.nl,1443; databaseName=DatabaseNaam;";
    String user = "usernaam";
    String pass = "wachtwoord";

    try {
      Connection connection = DriverManager.getConnection(dburl, user, pass);
      System.out.println("Connected!");
    } catch (SQLException e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
  }
}