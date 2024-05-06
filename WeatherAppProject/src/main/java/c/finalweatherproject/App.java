/*********************************************************************************************************************************
* File: App.java                                                                                                                 *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is the main file for the application. It is used to start the application and load the primary fxml file.   *
**********************************************************************************************************************************/

package c.finalweatherproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage; // Create a stage variable to be able to access the stage from other classes

    @Override
    public void start(Stage stage) throws IOException { // Start the application
        scene = new Scene(loadFXML("primary"), 1000, 600); // Load the primary fxml file
        this.stage = stage;
        this.stage.setTitle("Weather Info");
        this.stage.setScene(scene);
        this.stage.setResizable(false); // Disable resizing
        this.stage.show(); 
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    public static Stage getStage() {return stage;} // Get the stage - Used to see if the stage is open or not

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}