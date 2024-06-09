package ca.georgiancollege.assignment1gc8953;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class OntarioTableController {


    @FXML
    private TableView<Province> tableView;

    @FXML
    void initialize() {
        TableColumn<Province, Integer> ID = new TableColumn<>("ID");

        TableColumn<Province, String> YEAR = new TableColumn<>("YEAR");

        TableColumn<Province, Integer> POPULATION = new TableColumn<>("POPULATION");


        // Agregar las columnas al TableView
        tableView.getColumns().addAll(ID, YEAR, POPULATION);

        loadProvinceData();
    }

    private void loadProvinceData() {
        ObservableList<Province> provinceData = FXCollections.observableArrayList();

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://database-1.cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306/COMP1011", "admin", "Narangita412.");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM ONTARIO");
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("YEAR");
                int population = resultSet.getInt("POPULATION");
                Province province = new Province(id, year, population);
                provinceData.add(province);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableView.setItems(provinceData);
    }

}
