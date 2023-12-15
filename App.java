import java.sql.*;

public class App {
  public static void main(String[] args) {
    String url = "jdbc:sqlserver://localhost;databaseName=DatabaseNaam;user=usernaam;password=wachtwoord;encrypt=true;trustServerCertificate=true";
    String username = "usernaam";
    String password = "wachtwoord";
    try {
      Connection connection = DriverManager.getConnection(url);
      System.out.println("Connected!");

    } catch (Exception e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
  }
}