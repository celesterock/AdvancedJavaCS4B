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

    // game board
    private TicTacToe game = new TicTacToe();

    // create a 2D array of Buttons
    @FXML
    private Button[][] buttonArray = new Button[3][3];

    @FXML
    public void initialize() {
        buttonArray[0][0] = arr00;
        buttonArray[0][1] = arr01;
        buttonArray[0][2] = arr02;

        buttonArray[1][0] = arr10;
        buttonArray[1][1] = arr11;
        buttonArray[1][2] = arr12;

        buttonArray[2][0] = arr20;
        buttonArray[2][1] = arr21;
        buttonArray[2][2] = arr22;
    }


    // we want to go back to the welcome screen
    public void goWelcome(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("welcomeScene.fxml"));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    }



    // // ---------------------------------------------------
    // // these will be deleted, they were just for testing
    // int turnCount = 0;

    // public char getToken() {
    //     if(turnCount % 2 == 0) {
    //         turnCount++;
    //         return 'X';
    //     }
    //     turnCount++;
    //     return 'O';
    // }
    // // ------------------------------------------------------

    @FXML
    void placeToken(ActionEvent event) {
        Button selectedButton = (Button) event.getSource();
        String fxid = selectedButton.getId();

        /* Can delete this comment after reading:
         *  This section is needed to correlate the button that was clicked with the 2D array that will be created
         *  to keep track of the game. Use the row and col to set the player's token in the array and check
         *  for win/tie
         */
        // extract the row and column of the selected button (arr[row][col])
        int row = Character.getNumericValue(fxid.charAt(fxid.length() - 2));
        int col =  Character.getNumericValue(fxid.charAt(fxid.length() - 1));

        // // get the token of the current player
        // char token = getToken();

        // place the token on the board
        selectedButton.setText("X");

        // Disable the button so that it cannot be pressed again
        selectedButton.setDisable(true);

        /* this changes the background color of the button once it is clicked
         * we will update the styling later, I just set it to this value
         * to show it can change color */
        // update the button color
        selectedButton.setStyle("-fx-background-color: #000080;");

        // After the player has taken a turn, now do the computer's turn
        if(!game.winAchieved() && !game.tieAchieved()) {
            getCompuerMove();
        }
        else {
            // this is where we would display the appropriate win/tie/loss screen
        }
    }

    public void getCompuerMove() {
        // function to get computer move: (getComputerMove)
        int[] computerMoveArray = new int[2];
        computerMoveArray = game.getComputerMoveArray();


        //update our 2D array



        // to make the computer "click" on the screen, we need to update the buttonArray
        Button selectedButton = buttonArray[computerMoveArray[0]][computerMoveArray[1]]; 
        selectedButton.setText("O");

        // Disable the button so that it cannot be pressed again
        selectedButton.setDisable(true);

        /* this changes the background color of the button once it is clicked
            * we will update the styling later, I just set it to this value
            * to show it can change color */
        // update the button color
        selectedButton.setStyle("-fx-background-color: #000080;");



        // update the UI 

        // check for win and switch back to player's turn
        if(!game.winAchieved() && !game.tieAchieved()) {
            getCompuerMove();
        }
        else {
            // this is where we would display the appropriate win/tie/loss screen
        }
    }
    


}
