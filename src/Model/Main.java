package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Extend main class from javafx.application.Application and override its start() method
 * Load the login FXML document using FXML loader
 * This gives reference to the root node of the user interface
 * Then creates a Scene using the FXML root node and set the scene into the primary stage
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/login.fxml"));
        primaryStage.setTitle("Maze Game");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
        }

        public static void main(String[]args){
            launch(args);
        }

    }

