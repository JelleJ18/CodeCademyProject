package CodeCademy.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CertificaatGUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Certificaat");

        Label certificaatIDLabel = new Label("Certificaat ID:");
        TextField certificaatIDField = new TextField();

        Label beoordelingLabel = new Label("Beoordeling:");
        TextField beoordelingField = new TextField();

        Label medewerkerNaamLabel = new Label("Naam medewerker:");
        TextField medewerkerNaamField = new TextField();

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> saveCertificaatData(
                certificaatIDField.getText(),
                beoordelingField.getText(),
                medewerkerNaamField.getText()));

        VBox layout = new VBox(10, certificaatIDLabel, certificaatIDField,
                beoordelingLabel, beoordelingField,
                medewerkerNaamLabel, medewerkerNaamField,
                saveButton);

        Scene scene = new Scene(layout, 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    private void saveCertificaatData(String certificaatID, String beoordeling, String medewerkerNaam) {
        // Implementeer de logica om certificaatgegevens op te slaan in de database
        // Bijvoorbeeld: aanmaken van een nieuw Certificaat en opslaan in de database
        Certificaat nieuwCertificaat = new Certificaat(certificaatID, beoordeling, medewerkerNaam);
        // Opslaan van 'nieuwCertificaat' in de database via de juiste methode of klasse
    }
}
