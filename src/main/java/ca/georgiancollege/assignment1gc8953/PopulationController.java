package ca.georgiancollege.assignment1gc8953;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PopulationController {


    @FXML
    private BarChart<String, Number> OntarioChart;

    @FXML
    void initialize() {

        XYChart.Series<String, Number> data = new XYChart.Series<>();



        try(
                Connection connection = DriverManager.getConnection("jdbc:mysql://database-1" +
                        ".cpiiw6m2micq.us-east-2.rds.amazonaws.com:3306/COMP1011", "admin",
                "Narangita412.");
            Statement statement = connection.createStatement()){

            String query = "SELECT Year, Population FROM ONTARIO";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String year = resultSet.getString("Year");
                int population = resultSet.getInt("Population");
                data.getData().add(new XYChart.Data<>(year, population));


            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }

        OntarioChart.getData().add(data);
        OntarioChart.setTitle("Population in Ontario");
        OntarioChart.setLegendVisible(false);


    }


}
