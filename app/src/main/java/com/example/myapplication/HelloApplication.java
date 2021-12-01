/**
 * This class is the main runner class for the JavaFX Application

 * @author Divyesh Nemam Baskaran, Viraj Patel
 *
 */

package com.example.myapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    /**
     * This method starts the hello-view.fxml and starts the application
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene storeFront = new Scene(fxmlLoader.load(), 625, 650);
        stage.setTitle("RU Pizza Store Front");
        stage.setScene(storeFront);
        stage.show();
    }

    /**
     * This main method is run and launches the rest of the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}