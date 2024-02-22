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
import javafx.animation.PauseTransition; // delay computer move
import javafx.util.Duration;             // delay computer move

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

    // Holds a reference to the stage
    private Stage stage;
    private Scene scene;
    private Parent root;

    // game board
    private TicTacToe game = new TicTacToe();

    // File Names
    private String WELCOME_PAGE = "welcomeScene.fxml";
    private String PLAYER_WINS_FILE = "playerWinsScreen.fxml";
    private String COMPUTER_WINS_FILE = "ComputerWins.fxml";
    private String TIE_GAME_FILE = "CatsTie.fxml";

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

        game.initBoard();
    }


    // we want to go back to the welcome screen
    public void goWelcome(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource(WELCOME_PAGE));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    }


    @FXML
    void placeToken(ActionEvent event) {

        // Sets the stage reference
        if(stage == null) {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        }

        Button selectedButton = (Button) event.getSource();
        String fxid = selectedButton.getId();

        // extract the row and column of the selected button (arr[row][col])
        int row = Character.getNumericValue(fxid.charAt(fxid.length() - 2));
        int col =  Character.getNumericValue(fxid.charAt(fxid.length() - 1));

        buttonArray[row][col].setText("X");

        // set the token of the current player
        char token = 'X';
        game.setToken(row, col);

        // Disable the button so that it cannot be pressed again
        selectedButton.setDisable(true);

        /* this changes the background color of the button once it is clicked
         * we will update the styling later, I just set it to this value
         * to show it can change color */
        // update the button color
        selectedButton.setStyle("-fx-background-color: #000080;");


        if(game.winAchieved(token)) {
            // display the win screen
           switchToReultScreen(PLAYER_WINS_FILE);

        }
        else if (game.tieAchieved()) {
            // display the tie screen
            switchToReultScreen(TIE_GAME_FILE);
        }
        else {
            // allow computer to pick a move
            getComputerMove();
        }


    }

    public void getComputerMove() {

        // Create a PauseTransition: computer will be "thinking" for 1 second
        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        // Code that should happen AFTER the pause
        pause.setOnFinished(event -> {
            // function to get computer move: (getComputerMove)
            int[] computerMoveArray = new int[2];
            computerMoveArray = game.getComputerMoveArray();


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


            if(game.winAchieved('O')) {
                // display the win screen
                switchToReultScreen(COMPUTER_WINS_FILE);
            }
            else if (game.tieAchieved()) {
            switchToReultScreen(TIE_GAME_FILE);
            }
        });

        // start the pause
        pause.play();

    }


    /* Takes in the appropriate FXML FileName depending on who the winner is
     * Uses a reference to the stage object (initialized in placeToken())
     * because the win/tie screens need to be called without a specific button */
    private void switchToReultScreen(String fxmlFileName) {
         // Create a PauseTransition
         PauseTransition pause = new PauseTransition(Duration.seconds(1));

         // After the pause..
         pause.setOnFinished(event -> {
            try {
            
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                    Parent root = loader.load();
                    Scene newScene = new Scene(root);
                    stage.setScene(newScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //start the pause
        pause.play();
    }
}
