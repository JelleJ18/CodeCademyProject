import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GUI extends Application {

    private static final String JDBC_URL = "aei-sql2.avans.nl,1443"; // Replace with your database URL

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TableView tableView = new TableView();

        // Create columns for the table
        TableColumn<String, Record> naam = new TableColumn<>("Column1");
        naam.setCellValueFactory(cellData -> cellData.getValue().naamProperty());

        TableColumn<String, Record> column2 = new TableColumn<>("Column2");
        column2.setCellValueFactory(cellData -> cellData.getValue().column2Property());

        // Add columns to the table
        tableView.getColumns().addAll(naam, column2);

        try (Connection connection = DriverManager.getConnection(JDBC_URL);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name")) {

            while (resultSet.next()) {
                Record record = new Record(resultSet.getString("column1"), resultSet.getString("column2"));
                tableView.getItems().add(record);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        VBox root = new VBox(tableView);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Database Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static class Record {
        private final String column1;
        private final String column2;

        public Record(String column1, String column2) {
            this.column1 = column1;
            this.column2 = column2;
        }

        public String getColumn1() {
            return column1;
        }

        public String getColumn2() {
            return column2;
        }

        public StringProperty column1Property() {
            return new SimpleStringProperty(naam);
        }

        public StringProperty column2Property() {
            return new SimpleStringProperty(column2);
        }
    }

}