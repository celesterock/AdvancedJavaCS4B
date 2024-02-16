import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class SinglePlayer {

    @FXML
    private AnchorPane aPane;

    @FXML
    private Button arr00;

    @FXML
    private Button arr01;

    @FXML
    private Button arr02;

    @FXML
    private Button arr10;

    @FXML
    private Button arr11;

    @FXML
    private Button arr12;

    @FXML
    private Button arr20;

    @FXML
    private Button arr21;

    @FXML
    private Button arr22;

    @FXML
    private Label compLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Label playerLabel;

    @FXML
    private Label singleLabel;

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


    int turnCount = 0;

    public String getToken() {
        if(turnCount % 2 == 0) {
            turnCount++;
            return "X";
        }
        turnCount++;
        return "O";
    }
    
    @FXML
    void placeToken00(ActionEvent event) {
        arr00.setText(getToken());
    }

    @FXML
    void placeToken01(ActionEvent event) {
        arr01.setText(getToken());
    }

    @FXML
    void placeToken02(ActionEvent event) {
        arr02.setText(getToken());
    }

    @FXML
    void placeToken10(ActionEvent event) {
        arr10.setText(getToken());
    }

    @FXML
    void placeToken11(ActionEvent event) {
        arr11.setText(getToken());
    }

    @FXML
    void placeToken12(ActionEvent event) {
        arr12.setText(getToken());
    }

    @FXML
    void placeToken20(ActionEvent event) {
        arr20.setText(getToken());
    }

    @FXML
    void placeToken21(ActionEvent event) {
        arr21.setText(getToken());
    }

    @FXML
    void placeToken22(ActionEvent event) {
        arr22.setText(getToken());
    }

}
