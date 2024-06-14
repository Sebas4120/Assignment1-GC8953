package ca.georgiancollege.assignment1gc8953.Controllers;

import ca.georgiancollege.assignment1gc8953.DBUtil;
import ca.georgiancollege.assignment1gc8953.Models.OntarioModel;
import ca.georgiancollege.assignment1gc8953.Runners.PopulationApplication;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.event.ActionEvent;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

public class PopulationController {


    @FXML
    private Button btnTable;

    @FXML
    private Label titleChart;


    @FXML
    private BarChart<String, Number> OntarioChart;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton totalRadio;

    private DBUtil dbUtil;

    @FXML
    public void initialize(){

        populateChart();

        btnTable.setOnAction(event -> {
            try {
                PopulationApplication.switchScene("/ca/georgiancollege/assignment1gc8953/OntarioTable.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void populateChart(){
        totalRadio.setSelected(true);

        //Setting the title of the chart
        titleChart.setText("Total Population in Ontario (1970 - 2024)");

        //Getting the data from the model
        List<OntarioModel> ontarioModels = OntarioModel.getOntarioData();

        //Creating the series
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Total Ontario Population (1970 - 2024)");

        //Adding the data to the series
        for (OntarioModel ontarioModel : ontarioModels){
            series.getData().add(new XYChart.Data<>(ontarioModel.getYear(), ontarioModel.getPopulation()));

            System.out.println(ontarioModel.getPopulation());
        }

        //Adding the series to the chart
        OntarioChart.getData().add(series);
    }

    //Action to change to Male Population
    @FXML
    void changeMale(ActionEvent event) {
        if(maleRadio.isSelected()) {

            //Setting to the other radio buttons to false
            femaleRadio.setSelected(false);
            totalRadio.setSelected(false);

            //Setting the title of the chart
            titleChart.setText("Male Population in Ontario (1970 - 2024)");

            //Clearing the chart
            OntarioChart.getData().clear();

            //Getting the data from the model
            List<OntarioModel> ontarioModels = OntarioModel.getOntarioData2();

            //Creating the series
            XYChart.Series<String,Number> series = new XYChart.Series<>();
            series.setName("Male Population in Ontario (1970 - 2024)");

            //Adding the data to the series
            for (OntarioModel ontarioModel : ontarioModels){
                series.getData().add(new XYChart.Data<>(ontarioModel.getYear(), ontarioModel.getMale()));

                System.out.println(ontarioModel.getYear());
                System.out.println(ontarioModel.getMale());
            }

            //Adding the series to the chart
            OntarioChart.getData().add(series);
        }
    }

//*******************************************************************
    //Action to change to female Population
    @FXML
    void changeFemale(ActionEvent event) {
        if(femaleRadio.isSelected()) {
            //Setting to the other radio buttons to false
            maleRadio.setSelected(false);
            totalRadio.setSelected(false);

            //Setting the title of the chart
            titleChart.setText("Female Population in Ontario (1970 - 2024)");

            //Clearing the chart
            OntarioChart.getData().clear();

            //Getting the data from the model
            List<OntarioModel> ontarioModels = OntarioModel.getOntarioData2();

            //Creating the series
            XYChart.Series<String,Number> series = new XYChart.Series<>();
            series.setName("Female Population in Ontario (1970 - 2024)");

            //Adding the data to the series
            for (OntarioModel ontarioModel : ontarioModels){
                series.getData().add(new XYChart.Data<>(ontarioModel.getYear(),
                        ontarioModel.getFemale()));

                System.out.println(ontarioModel.getFemale());
            }

            //Adding the series to the chart
            OntarioChart.getData().add(series);
        }
    }

//******************************************************************
    //Action to change to Total Population
    @FXML
    void changeTotal(ActionEvent event) {
        if(totalRadio.isSelected()) {
            //Setting to the other radio buttons to false
            maleRadio.setSelected(false);
            femaleRadio.setSelected(false);

            //Clearing the chart
            OntarioChart.getData().clear();

            populateChart();
        }
    }





}
