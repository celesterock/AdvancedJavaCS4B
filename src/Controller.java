import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    // we want to go back to the welcome screen
    public void goWelcome(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    }


    // the welcome page is open and we want to go to the gameRule page
    public void switchToRules(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("gameRules.fxml"));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    }


    // welcome page --> One Player Game
    public void goOnePlayerGame(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("singlePlayerScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // welcome page --> Online Player Game
    public void goOnlineGame(ActionEvent event)  throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("onlineGameScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // welcome page --> Two Player Game
    public void goTwoPlayerGame(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("twoPlayerScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void confirmExit(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("confirmExit.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    
    
   }
