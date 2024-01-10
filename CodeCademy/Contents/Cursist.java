package CodeCademy.Contents;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cursist {
  private final StringProperty name;
  private String email;
  private LocalDate dateOfBirth;
  private String gender;
  private String address;
  private String hometown;
  private String country;

  public Cursist(String name) {
    this.name = new SimpleStringProperty(name);
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.address = address;
    this.hometown = hometown;
    this.country = country;
  }

  public String getNaam() {
    return name.get();
  }

  public void setNaam(String naam) {
    this.name.set(naam);
  }

  public StringProperty naamProperty() {
    return name;
  }

}
