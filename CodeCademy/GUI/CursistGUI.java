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

public class CursistGUI extends Application {
    Button button;
    private TableView<Cursist> tableView = new TableView<>();
    private Button refresh = new Button("Refresh");
    private Button home = new Button("Home");
    private Stage stage;
    private MainHomeGUI homeGUI;

    @Override
    public void start(Stage stage) {
        stage.setTitle("CodeCademy Application");
        this.stage = stage;
        TableColumn<Cursist, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Cursist, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Cursist, LocalDate> dateColumn = new TableColumn<>("Date Of Birth");
        TableColumn<Cursist, String> genderColumn = new TableColumn<>("Gender");
        TableColumn<Cursist, String> addressColumn = new TableColumn<>("Address");
        TableColumn<Cursist, String> hometownColumn = new TableColumn<>("Hometown");
        TableColumn<Cursist, String> countryColumn = new TableColumn<>("Country");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
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

        HBox hbox = new HBox(home, refresh);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10.0));
        VBox vBox1 = new VBox(hbox, tableView);
        refresh.setOnMouseClicked(this::populateTable);

        emailColumn.setPrefWidth(200);
        addressColumn.setPrefWidth(250);
        hometownColumn.setPrefWidth(200);
        countryColumn.setPrefWidth(150);

        populateTable(new Event(EventType.ROOT));

        Scene scene = new Scene(vBox1, 1000, 600);
        tableView.prefHeightProperty().bind(scene.heightProperty());
        tableView.prefWidthProperty().bind(scene.widthProperty());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private void populateTable(Event e) {
        tableView.setItems(FXCollections.observableArrayList(App.getCursist()));
    }

}
