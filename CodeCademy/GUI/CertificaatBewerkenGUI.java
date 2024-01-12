package CodeCademy.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificaatBewerkenGUI extends Application {

    private TextField certificaatIdField;
    private TextField beoordelingField;
    private TextField medewerkerNaamField;

    private Connection connection; // Jouw databaseverbinding

    @Override
    public void start(Stage stage) {
        stage.setTitle("Certificaat Bewerken");

        Label certificaatIdLabel = new Label("Certificaat ID:");
        certificaatIdField = new TextField();

        Label beoordelingLabel = new Label("Beoordeling:");
        beoordelingField = new TextField();

        Label medewerkerNaamLabel = new Label("Naam medewerker:");
        medewerkerNaamField = new TextField();

        Button fetchButton = new Button("Ophalen");
        fetchButton.setOnAction(e -> fetchCertificaatData());

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> saveCertificaatData());

        VBox layout = new VBox(10, certificaatIdLabel, certificaatIdField, fetchButton,
                beoordelingLabel, beoordelingField, medewerkerNaamLabel, medewerkerNaamField,
                saveButton);

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    private void fetchCertificaatData() {
        try {
            // Vervang 'jouw_query' door de daadwerkelijke query om certificaatgegevens op
            // te halen
            String query = "SELECT * FROM certificaat WHERE certificaat_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(certificaatIdField.getText()));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                beoordelingField.setText(resultSet.getString("beoordeling"));
                medewerkerNaamField.setText(resultSet.getString("medewerker_naam"));
                // Andere velden invullen op basis van je databasekolommen
            } else {
                // Certificaat niet gevonden
                clearFields();
                System.out.println("Certificaat niet gevonden.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCertificaatData() {
        // Implementeer logica om bewerkte gegevens op te slaan (vervang dit met je
        // eigen logica)
        String beoordeling = beoordelingField.getText();
        String medewerkerNaam = medewerkerNaamField.getText();
        // ... haal andere gegevens op

        // Voorbeeld: toon opgeslagen gegevens in de console
        System.out.println("Beoordeling: " + beoordeling);
        System.out.println("Naam medewerker: " + medewerkerNaam);
        // ... toon andere gegevens
    }

    private void clearFields() {
        beoordelingField.clear();
        medewerkerNaamField.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}