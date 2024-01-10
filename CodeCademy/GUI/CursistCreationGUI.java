package CodeCademy.GUI;

import CodeCademy.*;
import CodeCademy.Contents.Cursist;
import CodeCademy.Database.App;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.net.MalformedURLException;
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

    // Inputs
    private TextField nameField;
    private TextField emailField;
    private DatePicker dobPicker;
    private ComboBox<String> genderComboBox;
    private TextArea addressArea;
    private TextField cityField;
    private TextField countryField;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Nieuwe Cursist");

        Label nameLabel = new Label("Naam:");
        nameField = new TextField();

        Label emailLabel = new Label("E-mail:");
        emailField = new TextField();

        Label dobLabel = new Label("Geboortedatum:");
        dobPicker = new DatePicker();

        Label genderLabel = new Label("Geslacht:");
        genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Man", "Vrouw", "Anders");

        Label addressLabel = new Label("Adres:");
        addressArea = new TextArea();

        Label cityLabel = new Label("Woonplaats:");
        cityField = new TextField();

        Label countryLabel = new Label("Land:");
        countryField = new TextField();

        Button saveButton = new Button("Opslaan");
        saveButton.setOnMouseClicked(this::submitData);

        VBox layout = new VBox(10, nameLabel, nameField, emailLabel, emailField,
                dobLabel, dobPicker, genderLabel, genderComboBox,
                addressLabel, addressArea, cityLabel, cityField, countryLabel, countryField, saveButton);

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void submitData(Event e) {
        String selectedGender = genderComboBox.getSelectionModel().getSelectedItem();
        try {
            App.createCursist(
                    new Cursist(
                            nameField.getText(),
                            emailField.getText(),
                            dobPicker.getValue(),
                            selectedGender,
                            addressArea.getText(),
                            cityField.getText(),
                            countryField.getText()));
        } catch (NumberFormatException error) {
            System.out.println(error.getMessage());
            return;
        }

        stage.close();
    }
}
