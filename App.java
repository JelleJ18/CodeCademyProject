import java.sql.*;

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

      Statement statement = connection.createStatement();
      System.out.println("Connected!");

    } catch (Exception e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
  }
}