package ca.georgiancollege.assignment1gc8953;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class PopulationController {

    @FXML
    private BarChart<Number, Number> OntarioChart;

    @FXML
    void initialize() {

        XYChart.Series<Number, Number> data = new XYChart.Series<>();

        data.getData().add(new XYChart.Data<>(2011, 12851821));
    }


}
