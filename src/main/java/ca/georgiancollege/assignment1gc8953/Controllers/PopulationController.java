package ca.georgiancollege.assignment1gc8953.Controllers;

import ca.georgiancollege.assignment1gc8953.DBUtil;
import ca.georgiancollege.assignment1gc8953.Models.OntarioModel;
import ca.georgiancollege.assignment1gc8953.Runners.PopulationApplication;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

public class PopulationController {


    @FXML
    private Button btnChart;

    @FXML
    private BarChart<String, Number> OntarioChart;

    private DBUtil dbUtil;

    @FXML
    public void initialize(){
        populateChart();
    }



    private void populateChart(){
        List<OntarioModel> ontarioModels = OntarioModel.getOntarioData();

        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Ontario Population");

        for (OntarioModel ontarioModel : ontarioModels){
            series.getData().add(new XYChart.Data<>(ontarioModel.getYear(), ontarioModel.getPopulation()));
        }

        OntarioChart.getData().add(series);
    }




}
