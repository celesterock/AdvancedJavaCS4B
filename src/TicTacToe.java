
// this class will handle the game logic
import java.util.Random;

public class TicTacToe {
  private static int BOARD_DIMENSIONS = 3;
  private char[][] gameBoard = new char[BOARD_DIMENSIONS][BOARD_DIMENSIONS];
  private char Xtoken = 'X';
  private char Otoken = 'O';

  /*
   * Initialize the game board to ' ' (spaces). Thus, a space will mean the cell
   * has not been
   * taken yet
   */
  public void initBoard() {
    for (int i = 0; i < BOARD_DIMENSIONS; i++) {
      for (int j = 0; j < BOARD_DIMENSIONS; j++) {
        gameBoard[i][j] = ' ';
      }
    }
  }

  /* Set the correct token at the location that the player clicked */
  // I don't think we need to check if the space has been taken here because
  // the button will disappear once the space is taken so the player can't really
  // access a used spot
  void setToken(int row, int col) { // change name to setPlayerToken
    gameBoard[row][col] = Xtoken;
  }

  // randomly finds an empty space for the computer to place its move
  public int[] getComputerMoveArray() {
    int computerRow = 0;
    int computerCol = 0;

    Random rand = new Random();

    do {

      computerRow = rand.nextInt(3);
      computerCol = rand.nextInt(3);
      
    } while (gameBoard[computerRow][computerCol] != ' '); // if taken repeat while loop

    gameBoard[computerRow][computerCol] = Otoken;

    return new int[]{computerRow, computerCol};

  }

  // some type of function(s) to check for wins and ties
  public boolean winAchieved(char token) { //pass the token as a parameter to check for both computer and player
    // check the rows
    for (int i = 0; i < 3; i++) {
      if(gameBoard[i][0] == token && gameBoard[i][1] == token && gameBoard[i][2] == token) {
        return true;
      }
    }

    // check the columns
    for (int i = 0; i < 3; i++) {
      if(gameBoard[0][i] == token && gameBoard[1][i] == token && gameBoard[2][i] == token) {
        return true;
      }
    }

    // check the diagonals
    if(gameBoard[0][0] == token && gameBoard[1][1] == token && gameBoard[2][2] == token ||
       gameBoard[2][0] == token && gameBoard[1][1] == token && gameBoard[0][2] == token) {
          return true;
       }
  
    
    return false;
  }

  public boolean tieAchieved() { //if the gameboard is full and no one has won = tie *CHECK IF SOMEONE HAS WON BEFORE CALLING THIS*
    for (int i = 0; i < BOARD_DIMENSIONS; i++)
      {
        for (int j = 0; j < BOARD_DIMENSIONS; j++)
          {
            if (gameBoard[i][j] == ' ')
              return false;
          }
      }
    return true;
  }

}