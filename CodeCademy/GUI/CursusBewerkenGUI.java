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

public class CursusBewerkenGUI extends Application {

    private TextField cursusIdField;
    private TextField cursusNaamField;
    private TextField onderwerpField;
    private TextArea introductietekstArea;
    private ComboBox<String> niveauComboBox;

    private Connection connection; // Jouw databaseverbinding

    @Override
    public void start(Stage stage) {
        stage.setTitle("Cursus Bewerken");

        Label cursusIdLabel = new Label("Cursus ID:");
        cursusIdField = new TextField();

        Label cursusNaamLabel = new Label("Cursusnaam:");
        cursusNaamField = new TextField();

        Label onderwerpLabel = new Label("Onderwerp:");
        onderwerpField = new TextField();

        Label introductietekstLabel = new Label("Introductietekst:");
        introductietekstArea = new TextArea();

        Label niveauLabel = new Label("Niveau:");
        niveauComboBox = new ComboBox<>();
        niveauComboBox.getItems().addAll("Beginner", "Gevorderd", "Expert");

        Button fetchButton = new Button("Ophalen");
        fetchButton.setOnAction(e -> fetchCursusData());

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> saveCursusData());

        VBox layout = new VBox(10, cursusIdLabel, cursusIdField, fetchButton,
                cursusNaamLabel, cursusNaamField, onderwerpLabel, onderwerpField,
                introductietekstLabel, introductietekstArea, niveauLabel, niveauComboBox,
                saveButton);

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void fetchCursusData() {
        try {
            // Vervang 'jouw_query' door de daadwerkelijke query om cursusgegevens op te
            // halen
            String query = "SELECT * FROM cursus WHERE cursus_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(cursusIdField.getText()));

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cursusNaamField.setText(resultSet.getString("cursusnaam"));
                onderwerpField.setText(resultSet.getString("onderwerp"));
                introductietekstArea.setText(resultSet.getString("introductietekst"));
                niveauComboBox.setValue(resultSet.getString("niveau"));
                // Andere velden invullen op basis van je databasekolommen
            } else {
                // Cursus niet gevonden
                clearFields();
                System.out.println("Cursus niet gevonden.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCursusData() {
        // Implementeer logica om bewerkte gegevens op te slaan (vervang dit met je
        // eigen logica)
        String cursusNaam = cursusNaamField.getText();
        String onderwerp = onderwerpField.getText();
        String introductietekst = introductietekstArea.getText();
        String niveau = niveauComboBox.getValue();
        // ... haal andere gegevens op

        // Voorbeeld: toon opgeslagen gegevens in de console
        System.out.println("Cursusnaam: " + cursusNaam);
        System.out.println("Onderwerp: " + onderwerp);
        System.out.println("Introductietekst: " + introductietekst);
        System.out.println("Niveau: " + niveau);
        // ... toon andere gegevens
    }

    private void clearFields() {
        cursusNaamField.clear();
        onderwerpField.clear();
        introductietekstArea.clear();
        niveauComboBox.getSelectionModel().clearSelection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}