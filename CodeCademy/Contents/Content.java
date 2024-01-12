package CodeCademy.Contents;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Content {
    private ObjectProperty<LocalDate> publicatieDatum;
    private StringProperty status;
    private StringProperty cursusnaam;

    public Content(LocalDate publicatieDatum, String status, String cursusnaam) {
        this.publicatieDatum = new SimpleObjectProperty<>(publicatieDatum);
        this.status = new SimpleStringProperty(status);
        this.cursusnaam = new SimpleStringProperty(cursusnaam);
    }

    public LocalDate publicatieDatumProperty() {
        return publicatieDatum.get();
    }

    public void setPublicatieDatum(ObjectProperty<LocalDate> publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(StringProperty status) {
        this.status = status;
    }

    public String getCursusnaam() {
        return cursusnaam.get();
    }

    public void setCursusnaam(StringProperty cursusnaam) {
        this.cursusnaam = cursusnaam;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty cursusnaamProperty() {
        return cursusnaam;
    }

}
