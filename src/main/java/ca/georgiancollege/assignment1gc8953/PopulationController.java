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

    private DBUtil dbUtil;

    @FXML
    public void initialize(){
        populateChart();
    }

    private void populateChart(){
        List<Province> provinces = Province.getOntarioData();

        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Ontario Population");

        for (Province province: provinces){
            series.getData().add(new XYChart.Data<>(province.getYear(),province.getPopulation()));
        }

        OntarioChart.getData().add(series);
    }




}
