public class Module {
  private String titel;
  private String versie;
  private int volgnummer;
  private String beschrijving;
  private String naamContactPers;
  private String emailContactPers;
  private int itemId;

  public Module(String titel, String versie, int volgnummer, String beschrijving, String naamContactPers,
      String emailContactPers, int itemId) {
    this.titel = titel;
    this.versie = versie;
    this.volgnummer = volgnummer;
    this.beschrijving = beschrijving;
    this.naamContactPers = naamContactPers;
    this.emailContactPers = emailContactPers;
    this.itemId = itemId;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public String getVersie() {
    return versie;
  }

  public void setVersie(String versie) {
    this.versie = versie;
  }

  public int getVolgnummer() {
    return volgnummer;
  }

  public void setVolgnummer(int volgnummer) {
    this.volgnummer = volgnummer;
  }

  public String getBeschrijving() {
    return beschrijving;
  }

  public void setBeschrijving(String beschrijving) {
    this.beschrijving = beschrijving;
  }

  public String getNaamContactPers() {
    return naamContactPers;
  }

  public void setNaamContactPers(String naamContactPers) {
    this.naamContactPers = naamContactPers;
  }

  public String getEmailContactPers() {
    return emailContactPers;
  }

  public void setEmailContactPers(String emailContactPers) {
    this.emailContactPers = emailContactPers;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

}
