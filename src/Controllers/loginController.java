package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import java.io.IOException;

public class loginController {

    @FXML
    private Label statusLbl;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    @FXML
    private AnchorPane rootPane;


    /***
     *
     * @param actionEvent
     * @throws IOException
     */
/*    public void login(ActionEvent actionEvent) throws IOException
    {
        if(txtUserName.getText().equals("U") && txtPassword.getText().equals("P")){
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../Views/GameScreen2.fxml"));
            primaryStage.setTitle("Maze Game");
            primaryStage.setScene(new Scene(root, 1080, 720));
            primaryStage.show();


        }else {
            statusLbl.setText("Incorrect username or password, please try again.");
        }

        
    }*/

    public void login(ActionEvent actionEvent) throws IOException
    {
        if(txtUserName.getText().equals("U") && txtPassword.getText().equals("P")){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("../Views/GameScreen2.fxml"));
            rootPane.getChildren().setAll(pane);

        }else {
            statusLbl.setText("Incorrect username or password, please try again.");
        }


    }
}
