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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class CursistGUI extends SceneWrapper {
    Button button;
    private TableView<Cursist> tableView = new TableView<>();
    private Button refresh = new Button("Refresh");
    private Button home = new Button("Home");
    private Button create = new Button("Create");
    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");

    TableColumn<Cursist, String> nameColumn = new TableColumn<>("Name");
    TableColumn<Cursist, String> emailColumn = new TableColumn<>("Email");
    TableColumn<Cursist, LocalDate> dateColumn = new TableColumn<>("Date Of Birth");
    TableColumn<Cursist, String> genderColumn = new TableColumn<>("Gender");
    TableColumn<Cursist, String> addressColumn = new TableColumn<>("Address");
    TableColumn<Cursist, String> hometownColumn = new TableColumn<>("Hometown");
    TableColumn<Cursist, String> countryColumn = new TableColumn<>("Country");

    public CursistGUI(Stage stage) {
        super(stage);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        hometownColumn.setCellValueFactory(new PropertyValueFactory<>("hometown"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        tableView = new TableView<>();
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(emailColumn);
        tableView.getColumns().add(dateColumn);
        tableView.getColumns().add(genderColumn);
        tableView.getColumns().add(addressColumn);
        tableView.getColumns().add(hometownColumn);
        tableView.getColumns().add(countryColumn);
        create.setPrefWidth(150);
        edit.setPrefWidth(150);
        delete.setPrefWidth(150);

        HBox hbox = new HBox(home, refresh);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10.0));
        VBox vBox1 = new VBox(hbox, tableView);
        VBox vbox2 = new VBox(create, edit, delete);
        vbox2.setStyle("-fx-padding: 45 0 0 0;");
        vbox2.setSpacing(10);
        HBox hBox2 = new HBox(vBox1, vbox2);

        home.setOnMouseClicked(this::goHome);
        refresh.setOnMouseClicked(this::populateTable);
        create.setOnMouseClicked(this::createTable);
        edit.setOnMouseClicked(this::editTable);
        delete.setOnMouseClicked(this::deleteTable);

        emailColumn.setPrefWidth(200);
        addressColumn.setPrefWidth(250);
        hometownColumn.setPrefWidth(200);
        countryColumn.setPrefWidth(150);
        this.scene = new Scene(hBox2);
        tableView.prefHeightProperty().bind(scene.heightProperty());
        tableView.prefWidthProperty().bind(scene.widthProperty());

        populateTable(new Event(EventType.ROOT));
    }

    private void populateTable(Event e) {
        tableView.setItems(FXCollections.observableArrayList(App.getCursisten()));
    }

    private void goHome(Event e) {
        GuiMain.SCENE_MANAGER.switchScene(SceneType.HOME);
    }

    private void createTable(Event e) {
        System.out.println("Creating");
    }

    private void editTable(Event e) {
        System.out.println("Editing");
    }

    private void deleteTable(Event e) {
        System.out.println("Deleting");
    }

}
