package ca.georgiancollege.assignment1gc8953.Runners;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PopulationApplication extends Application {

    private static Stage primaryStage;


    @Override
    public void start(Stage stage) throws IOException {

        primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(PopulationApplication.class.getResource("/ca/georgiancollege/assignment1gc8953/assignment-view.fxml"));

        System.out.println(fxmlLoader.getLocation());

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Population In Canada");
        stage.setScene(scene);
        stage.show();
    }

//    public static void switchScene(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(PopulationApplication.class.getResource(fxml));
//        Scene scene = new Scene(fxmlLoader.load());
//        primaryStage.setScene(scene);
//    }

    public static void main(String[] args) {
        launch();
    }
}