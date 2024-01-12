package CodeCademy.Database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import CodeCademy.Contents.Cursist;
import CodeCademy.Contents.Cursus;
import CodeCademy.CodeCad;
import CodeCademy.Contents.Certificaat;

public class App {
  private static Connection connection = CodeCad.connection;

  // Cursist methoden
  public static void createCursist(Cursist cursist) {
    try {
      PreparedStatement insertStatement = connection.prepareStatement(
          "INSERT INTO Cursist(naam, email, dateOfBirth, gender, address, hometown, country)\n" +
              "VALUES(?, ?, ?, ?, ?, ?, ?)");
      insertStatement.setString(1, cursist.getName());
      insertStatement.setString(2, cursist.getEmail());
      insertStatement.setDate(3, Date.valueOf(cursist.getDateOfBirth()));
      insertStatement.setString(4, cursist.getGender());
      insertStatement.setString(5, cursist.getAddress());
      insertStatement.setString(6, cursist.getHometown());
      insertStatement.setString(7, cursist.getCountry());

      insertStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  public static List<Cursist> getCursisten() {
    return getCursisten(0);
  }

  public static List<Cursist> getCursisten(int offset) {
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
      handleSQLException(e);
    }

    return list;
  }

  public static void editCursist(Cursist cursist) {
    try {
      PreparedStatement updateStatement = connection.prepareStatement(
          "UPDATE Cursist SET email = ?, dateOfBirth = ?, gender = ?, address = ?, hometown = ?, country = ?\n" +
              "WHERE naam = ?");

      updateStatement.setString(1, cursist.getEmail());
      updateStatement.setDate(2, Date.valueOf(cursist.getDateOfBirth()));
      updateStatement.setString(3, cursist.getGender());
      updateStatement.setString(4, cursist.getAddress());
      updateStatement.setString(5, cursist.getHometown());
      updateStatement.setString(6, cursist.getCountry());
      updateStatement.setString(7, cursist.getName());

      updateStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  // Cursus methoden
  public static void createCursus(Cursus cursus) {
    try {
      PreparedStatement insertStatement = connection.prepareStatement(
          "INSERT INTO Cursus(cursusnaam, onderwerp, introductietekst, niveau)\n" +
              "VALUES(?, ?, ?, ?)");
      insertStatement.setString(1, cursus.getCursusNaam());
      insertStatement.setString(2, cursus.getOnderwerp());
      insertStatement.setString(3, cursus.getIntroductietekst());
      insertStatement.setString(4, cursus.getNiveau());

      insertStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  public static List<Cursus> getCursussen() {
    return getCursussen(0);
  }

  public static List<Cursus> getCursussen(int offset) {
    ArrayList<Cursus> list = new ArrayList<>();

    try {
      PreparedStatement selectCursus = connection.prepareStatement(
          "SELECT * FROM Cursus ORDER BY cursusnaam OFFSET ? ROWS FETCH NEXT 100 ROWS ONLY");

      selectCursus.setInt(1, offset);

      ResultSet rs = selectCursus.executeQuery();

      while (rs.next()) {
        list.add(new Cursus(
            rs.getString("cursusnaam"),
            rs.getString("onderwerp"),
            rs.getString("introductietekst"),
            rs.getString("niveau")));
      }

    } catch (SQLException e) {
      handleSQLException(e);
    }

    return list;
  }

  public static void editCursus(Cursus cursus) {
    try {
      PreparedStatement updateStatement = connection.prepareStatement(
          "UPDATE Cursus SET onderwerp = ?, introductietekst = ?, niveau = ?\n" +
              "WHERE cursusnaam = ?");

      updateStatement.setString(1, cursus.getOnderwerp());
      updateStatement.setString(2, cursus.getIntroductietekst());
      updateStatement.setString(3, cursus.getNiveau());
      updateStatement.setString(4, cursus.getCursusNaam());

      updateStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  // Certificaat methoden
  public static void createCertificaat(Certificaat certificaat) {
    try {
      PreparedStatement insertStatement = connection.prepareStatement(
          "INSERT INTO Certificaat(beoordeling, medewerker_naam)\n" +
              "VALUES(?, ?)");
      insertStatement.setString(1, certificaat.getBeoordeling());
      insertStatement.setString(2, certificaat.getMedewerkerNaam());

      insertStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  public static List<Certificaat> getCertificaten() {
    return getCertificaten(0);
  }

  public static List<Certificaat> getCertificaten(int offset) {
    ArrayList<Certificaat> list = new ArrayList<>();

    try {
      PreparedStatement selectCertificaat = connection.prepareStatement(
          "SELECT * FROM Certificaat ORDER BY certificaatID OFFSET ? ROWS FETCH NEXT 100 ROWS ONLY");

      selectCertificaat.setInt(1, offset);

      ResultSet rs = selectCertificaat.executeQuery();

      while (rs.next()) {
        list.add(new Certificaat(
            rs.getInt("certificaatID"),
            rs.getString("beoordeling"),
            rs.getString("medewerker_naam")));
      }

    } catch (SQLException e) {
      handleSQLException(e);
    }

    return list;
  }

  public static void editCertificaat(Certificaat certificaat) {
    try {
      PreparedStatement updateStatement = connection.prepareStatement(
          "UPDATE Certificaat SET beoordeling = ?, medewerker_naam = ?\n" +
              "WHERE certificaatID = ?");

      updateStatement.setString(1, certificaat.getBeoordeling());
      updateStatement.setString(2, certificaat.getMedewerkerNaam());
      updateStatement.setInt(3, certificaat.getCertificaatID());

      updateStatement.executeUpdate();
    } catch (SQLException e) {
      handleSQLException(e);
    }
  }

  private static void handleSQLException(SQLException e) {
    if (e.getSQLState().equals("23505")) {
      System.out.println("Duplicaat primaire sleutel!!");
    } else {
      System.out.println("SQL-fout: " + e.getMessage());
    }
  }
}