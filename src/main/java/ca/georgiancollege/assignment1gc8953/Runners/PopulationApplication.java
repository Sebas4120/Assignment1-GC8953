package ca.georgiancollege.assignment1gc8953.Runners;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class PopulationApplication extends Application {

    //Static reference to the primary stage of the application
    private static Stage primaryStage;

    //The start method is the main entry point for all JavaFX applications.
    @Override
    public void start(Stage stage) throws IOException {

        //Assign the primary stage to a static variable so it can be accessed later
        primaryStage = stage;

        //Load the FXML file for the initial scene
        FXMLLoader fxmlLoader = new FXMLLoader(PopulationApplication.class.
                getResource("/ca/georgiancollege/assignment1gc8953/assignment-view.fxml"));

//        System.out.println(fxmlLoader.getLocation());

        //Creation of a new scene with the loaded FXML file
        Scene scene = new Scene(fxmlLoader.load());
        //Setting title
        stage.setTitle("Population In Ontario (1970 - 2024)");
        //Set the scene for the primary stage
        stage.setScene(scene);
        //To add the icon to the stage
        stage.getIcons().addAll(
                new Image(String.valueOf(getClass().
                        getResource("/images/Ontario.jpg")))
        );
        //Displays the main window.
        stage.show();
    }

    //Method to switch scenes within the application
    public static void switchScene(String fxml) throws IOException {
        //Load the new FXML file for the scene to switch to
        FXMLLoader fxmlLoader = new FXMLLoader(PopulationApplication.class.getResource(fxml));
        //Creation of a new scene with the loaded FXML file
        Scene scene = new Scene(fxmlLoader.load());
        // Set the new scene for the primary stage
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}