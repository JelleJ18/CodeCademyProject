package CodeCademy.Contents;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cursist {
  private final StringProperty name;
  private StringProperty email;
  private final ObjectProperty<LocalDate> dateOfBirth;
  private StringProperty gender;
  private StringProperty address;
  private StringProperty hometown;
  private StringProperty country;

  public Cursist(String name, String email, LocalDate dateOfBirth, String gender, String address,
      String hometown,
      String country) {
    this.name = new SimpleStringProperty(name);
    this.email = new SimpleStringProperty(email);
    this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
    this.gender = new SimpleStringProperty(gender);
    this.address = new SimpleStringProperty(address);
    this.hometown = new SimpleStringProperty(hometown);
    this.country = new SimpleStringProperty(country);
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

  public StringProperty emailProperty() {
    return email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth.get();
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth.set(dateOfBirth);
  }

  public ObjectProperty<LocalDate> dateOfBirthProperty() {
    return dateOfBirth;
  }

  public StringProperty genderProperty() {
    return gender;
  }

  public StringProperty addressProperty() {
    return address;
  }

  public StringProperty hometownProperty() {
    return hometown;
  }

  public StringProperty countryProperty() {
    return country;
  }

}
