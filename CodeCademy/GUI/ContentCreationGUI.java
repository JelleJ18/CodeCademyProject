package CodeCademy.GUI;

import CodeCademy.*;
import CodeCademy.Contents.Content;
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

public class ContentCreationGUI extends Application {
    Button button;
    private TableView<Cursist> tableView = new TableView<>();
    private Button refresh = new Button("Refresh");
    private Button home = new Button("Home");
    private Stage stage;
    private MainHomeGUI homeGUI;

    // Inputs
    private DatePicker dateField;
    private TextField statusfield;
    private TextField cursusnaamfield;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Nieuwe Content");

        Label dateLabel = new Label("Datum:");
        dateField = new DatePicker();

        Label statusLabel = new Label("Status:");
        statusfield = new TextField();

        Label cursusnaamLabel = new Label("Cursusnaam:");
        cursusnaamfield = new TextField();

        Button saveButton = new Button("Opslaan");
        saveButton.setOnMouseClicked(this::submitData);

        VBox layout = new VBox(10, dateLabel, dateField, statusLabel, statusfield,
                cursusnaamLabel, cursusnaamfield, saveButton);

        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void submitData(Event e) {
        try {
            App.createContent(
                    new Content(
                            dateField.getValue(),
                            statusfield.getText(),
                            cursusnaamfield.getText()));

        } catch (NumberFormatException error) {
            System.out.println(error.getMessage());
            return;
        }

        stage.close();
    }
}
