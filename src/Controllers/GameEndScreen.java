package Controllers;

import Model.Main;
import Readers.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GameEndScreen {

    @FXML
    public Label endGameWealthLbl;
    @FXML
    AnchorPane rootPaneES;

    @FXML
    public void initialize(){
        endGameWealthLbl.setText("£"+ String.valueOf(Reader.totalWealth));
    }


/*
    public void restartGame(ActionEvent actionEvent) throws IOException{
        Stage primaryStage = new Stage();
        URL url = new File("TestFX/src/Views/GameScreen.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Maze Game");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }

 */
    @FXML
    public void restartGame(ActionEvent actionEvent) throws IOException{
        try {
            Runtime.getRuntime().exec("java -jar MazeGame.jar");
            System.exit(0);
        } catch (IOException e ){

        }
        //URL url = new File("TestFX/src/Views/GameScreen2.fxml").toURI().toURL();
        //AnchorPane pane = FXMLLoader.load(url);
        //rootPaneES.getChildren().setAll(pane);

    }

}
