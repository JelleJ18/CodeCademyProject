import java.time.LocalDate;

public class Cursist {
  private String name;
  private String email;
  private LocalDate dateOfBirth;
  private String gender;
  private String address;
  private String hometown;
  private String country;

  public Cursist(String name, String email, LocalDate dateOfBirth, String gender, String address, String hometown,
      String country) {
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.address = address;
    this.hometown = hometown;
    this.country = country;
  }

  public void SchrijfIn() {
    System.out.println("Ingeschreven voor *cursusnaam*");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getHometown() {
    return hometown;
  }

  public void setHometown(String hometown) {
    this.hometown = hometown;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}
// hallo