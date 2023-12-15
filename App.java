import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
  public static void main(String[] args) {
    String dburl = "jdbc:sqlserver://localhost;databaseName=DatabaseNaam;user=usernaam;password=wachtwoord;encrypt=true;TrustServerCertificate=True";
    try {
      Connection connection = DriverManager.getConnection(dburl);
      System.out.println("Connected!");
    } catch (SQLException e) {
      System.out.println("Oops. error!");
      e.printStackTrace();
    }
  }
}