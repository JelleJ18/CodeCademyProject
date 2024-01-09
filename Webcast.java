import java.time.LocalDate;

public class Webcast {
  private String titel;
  private String beschrijving;
  private String sprekerNaam;
  private String sprekerOrganisatie;
  private String tijdsduur;
  private LocalDate datum;
  private String URL;
  private int itemId;

  public Webcast(String titel, String beschrijving, String sprekerNaam, String sprekerOrganisatie, String tijdsduur,
      LocalDate datum, String uRL, int itemId) {
    this.titel = titel;
    this.beschrijving = beschrijving;
    this.sprekerNaam = sprekerNaam;
    this.sprekerOrganisatie = sprekerOrganisatie;
    this.tijdsduur = tijdsduur;
    this.datum = datum;
    URL = uRL;
    this.itemId = itemId;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getBeschrijving() {
    return beschrijving;
  }

  public void setBeschrijving(String beschrijving) {
    this.beschrijving = beschrijving;
  }

  public String getSprekerNaam() {
    return sprekerNaam;
  }

  public void setSprekerNaam(String sprekerNaam) {
    this.sprekerNaam = sprekerNaam;
  }

  public String getSprekerOrganisatie() {
    return sprekerOrganisatie;
  }

  public void setSprekerOrganisatie(String sprekerOrganisatie) {
    this.sprekerOrganisatie = sprekerOrganisatie;
  }

  public String getTijdsduur() {
    return tijdsduur;
  }

  public void setTijdsduur(String tijdsduur) {
    this.tijdsduur = tijdsduur;
  }

  public LocalDate getDatum() {
    return datum;
  }

  public void setDatum(LocalDate datum) {
    this.datum = datum;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String uRL) {
    URL = uRL;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

}
