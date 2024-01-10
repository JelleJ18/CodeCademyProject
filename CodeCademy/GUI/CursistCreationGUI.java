package CodeCademy.GUI;

import CodeCademy.*;
import CodeCademy.Contents.Cursist;
import CodeCademy.Database.App;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

import CodeCademy.Contents.Cursist;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

public class CursistCreationGUI extends Application {
    Button button;
    private TableView<Cursist> tableView = new TableView<>();
    private Button refresh = new Button("Refresh");
    private Button home = new Button("Home");
    private Stage stage;
    private MainHomeGUI homeGUI;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Nieuwe Cursist");

        Label nameLabel = new Label("Naam:");
        TextField nameField = new TextField();

        Label emailLabel = new Label("E-mail:");
        TextField emailField = new TextField();

        Label dobLabel = new Label("Geboortedatum:");
        DatePicker dobPicker = new DatePicker();

        Label genderLabel = new Label("Geslacht:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Man", "Vrouw", "Anders");

        Label addressLabel = new Label("Adres:");
        TextArea addressArea = new TextArea();

        Label cityLabel = new Label("Woonplaats:");
        TextField cityField = new TextField();

        Label countryLabel = new Label("Land:");
        TextField countryField = new TextField();

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> saveCursistData(
                nameField.getText(),
                emailField.getText(),
                dobPicker.getValue(),
                genderComboBox.getValue(),
                addressArea.getText(),
                cityField.getText(),
                countryField.getText()));

        VBox layout = new VBox(10, nameLabel, nameField, emailLabel, emailField,
                dobLabel, dobPicker, genderLabel, genderComboBox,
                addressLabel, addressArea, cityLabel, cityField, countryLabel, countryField, saveButton);

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void saveCursistData(String naam, String email, LocalDate geboortedatum, String geslacht, String adres,
            String woonplaats, String land) {
        // Implementeer de logica om cursistgegevens op te slaan in de database
        // Voorbeeld: aanmaken van een nieuwe Cursist en opslaan in de database
        Cursist nieuweCursist = new Cursist(naam, email, geboortedatum, geslacht, adres, woonplaats, land);
        // Opslaan van 'nieuweCursist' in de database via de juiste methode of klasse
    }

    public static void main(String[] args) {
        launch(args);
    }
}
