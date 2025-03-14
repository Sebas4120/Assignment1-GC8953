package ca.georgiancollege.assignment1gc8953.Controllers;

import ca.georgiancollege.assignment1gc8953.Models.OntarioModel;
import ca.georgiancollege.assignment1gc8953.Runners.PopulationApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class OntarioTableController {

    //Button to switch to the other view
    @FXML
    private Button btn2;

    //Table view
    @FXML
    private TableView<OntarioModel> tableView;

    // Table columns
    @FXML
    private TableColumn<OntarioModel, Integer> idColumn;

    @FXML
    private TableColumn<OntarioModel, String> yearColumn;

    @FXML
    private TableColumn<OntarioModel, Integer> populationColumn;

    @FXML
    private TableColumn<OntarioModel, Integer> maleColumn;

    @FXML
    private TableColumn<OntarioModel, Integer> femaleColumn;

    public void initialize(){
        //Configuration of the columns to match the model attributes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        populationColumn.setCellValueFactory(new PropertyValueFactory<>("population"));
        maleColumn.setCellValueFactory(new PropertyValueFactory<>("male"));
        femaleColumn.setCellValueFactory(new PropertyValueFactory<>("female"));

        //Getting the data from the model
        ObservableList<OntarioModel> data =
                FXCollections.observableArrayList(OntarioModel.getOntarioData2());

        //Adding the data to the table
        tableView.setItems(data);

        //Button to switch to the other view
        btn2.setOnAction(event -> {
            try{
                PopulationApplication.switchScene("/ca/georgiancollege/assignment1gc8953/assignment-view.fxml");
            }catch (IOException e){
                e.printStackTrace();
            }

        });
    }



}
