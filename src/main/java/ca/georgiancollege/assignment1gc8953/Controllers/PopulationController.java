package ca.georgiancollege.assignment1gc8953.Controllers;

import ca.georgiancollege.assignment1gc8953.DBUtil;
import ca.georgiancollege.assignment1gc8953.Models.OntarioChartModel;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

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
        List<OntarioChartModel> ontarioChartModels = OntarioChartModel.getOntarioData();

        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Ontario Population");

        for (OntarioChartModel ontarioChartModel : ontarioChartModels){
            series.getData().add(new XYChart.Data<>(ontarioChartModel.getYear(), ontarioChartModel.getPopulation()));
        }

        OntarioChart.getData().add(series);
    }




}
