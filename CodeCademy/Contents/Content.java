package CodeCademy.Contents;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableObjectValue;

public class Content {
    private ObjectProperty<LocalDate> publicatieDatum;
    private StringProperty status;
    private StringProperty cursusnaam;

    public Content(LocalDate publicatieDatum, String status, String cursusnaam) {
        this.publicatieDatum = new SimpleObjectProperty<>(publicatieDatum);
        this.status = new SimpleStringProperty(status);
        this.cursusnaam = new SimpleStringProperty(cursusnaam);
    }

    public ObjectProperty<LocalDate> publicatieDatumProperty() {
        return publicatieDatum;
    }

    public void setPublicatieDatum(ObjectProperty<LocalDate> publicatieDatum) {
        this.publicatieDatum = publicatieDatum;
    }

    public StringProperty getStatus() {
        return status;
    }

    public void setStatus(StringProperty status) {
        this.status = status;
    }

    public StringProperty getCursusnaam() {
        return cursusnaam;
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
