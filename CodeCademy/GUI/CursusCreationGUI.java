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

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CursusCreationGUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Nieuwe Cursus");

        Label courseLabel = new Label("Cursusnaam:");
        TextField courseField = new TextField();

        Label subjectLabel = new Label("Onderwerp:");
        TextField subjectField = new TextField();

        Label introLabel = new Label("Introductietekst:");
        TextArea introArea = new TextArea();

        Label levelLabel = new Label("Niveau:");
        ComboBox<String> levelComboBox = new ComboBox<>();
        levelComboBox.getItems().addAll("Beginner", "Gevorderd", "Expert");

        Button saveButton = new Button("Opslaan");
        saveButton.setOnAction(e -> saveCursusData(
                courseField.getText(),
                subjectField.getText(),
                introArea.getText(),
                levelComboBox.getValue()));

        VBox layout = new VBox(10, courseLabel, courseField, subjectLabel, subjectField,
                introLabel, introArea, levelLabel, levelComboBox, saveButton);

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    private void saveCursusData(String cursusNaam, String onderwerp, String introductietekst, String niveau) {
        // Implementeer de logica om cursusgegevens op te slaan in de database
        // Bijvoorbeeld: aanmaken van een nieuwe Cursus en opslaan in de database
        Cursus nieuweCursus = new Cursus(cursusNaam, onderwerp, introductietekst, niveau);
        // Opslaan van 'nieuweCursus' in de database via de juiste methode of klasse
    }
}
