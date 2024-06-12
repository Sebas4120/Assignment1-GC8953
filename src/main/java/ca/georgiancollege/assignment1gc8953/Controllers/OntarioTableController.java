package ca.georgiancollege.assignment1gc8953.Controllers;

import ca.georgiancollege.assignment1gc8953.Models.OntarioChartModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OntarioTableController {


    @FXML
    private TableView<OntarioChartModel> tableView;

    @FXML
    private TableColumn<OntarioChartModel, Integer> idColumn;

    @FXML
    private TableColumn<OntarioChartModel, String> yearColumn;

    @FXML
    private TableColumn<OntarioChartModel, Integer> populationColumn;

    public void initialize(){
        //Configuration of the columns to match the model attributes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));

        //Getting the data from the model
        ObservableList<OntarioChartModel> data =
                FXCollections.observableArrayList(OntarioChartModel.getOntarioData2());

        //Adding the data to the table
        tableView.setItems(data);
    }

}
