package CodeCademy.GUI;

import CodeCademy.*;
import CodeCademy.Contents.Cursist;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WebcastGUI extends Application implements EventHandler<ActionEvent> {
    Button button;
    private TableView<Cursist> tableView;
    private static Connection connection = CodeCad.connection;

    @Override
    public void start(Stage stage) {
        stage.setTitle("CodeCademy Application");

        TableColumn<Cursist, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().naamProperty());

        tableView = new TableView<>();
        tableView.getColumns().add(nameColumn);

        populateTable();

        Scene mainView = new Scene(tableView, 600, 600);
        stage.setScene(mainView);
        stage.show();
    }

    @Override
    public void handle(ActionEvent arg0) {
        if (arg0.getSource() == button) {
            populateTable();
        }
    }

    private void populateTable() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cursist");

            ObservableList<Cursist> cursistList = FXCollections.observableArrayList();
            while (rs.next()) {
                cursistList.add(new Cursist(rs.getString("naam")));
            }

            tableView.setItems(cursistList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
