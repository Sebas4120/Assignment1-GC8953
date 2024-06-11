package ca.georgiancollege.assignment1gc8953;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class OntarioTableController {


    @FXML
    private TableView<Province> tableView;

    @FXML
    void initialize() throws SQLException {

        try {
            //Connection to my database
            Connection connection = DriverManager.getConnection("jdbc:mysql://database-1." +
                    "cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306/COMP1011", "admin"
                    , "Narangita412.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ONTARIO");

            //Creating columns and setting configuration
            TableColumn<Province, Integer> idColumn = new TableColumn<>("ID");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

            TableColumn<Province, String> yearColumn = new TableColumn<>("Year");
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

            TableColumn<Province, Integer> populationColumn = new TableColumn<>("Population");
            populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));


            // Agregar las columnas al TableView
            tableView.getColumns().addAll(idColumn, yearColumn, populationColumn);


            //Uploading the data from data base
            ObservableList<Province> data = FXCollections.observableArrayList();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String year = resultSet.getString("Year");
                int population = resultSet.getInt("Population");
                data.add(new Province(id, year, population));
            }

            //Adding the data to the TableView
            tableView.setItems(data);

        }catch (SQLException e){
            e.printStackTrace();
        }





    }

}
