package CodeCademy.Contents;

public class Certificaat {
  private int Id;
  private int beoordeling;
  private String medewerkerNaam;
  // certiciaat

  public Certificaat(int id, int beoordeling, String medewerkerNaam) {
    Id = id;
    this.beoordeling = beoordeling;
    this.medewerkerNaam = medewerkerNaam;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public int getBeoordeling() {
    return beoordeling;
  }

  public void setBeoordeling(int beoordeling) {
    this.beoordeling = beoordeling;
  }

  public String getMedewerkerNaam() {
    return medewerkerNaam;
  }

  public void setMedewerkerNaam(String medewerkerNaam) {
    this.medewerkerNaam = medewerkerNaam;
  }

}
