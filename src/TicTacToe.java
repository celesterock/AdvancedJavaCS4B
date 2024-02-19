// this class will handle the game logic

public class TicTacToe {
    private static int BOARD_DIMENSIONS = 3;
    private char[][] gameBoard = new char[BOARD_DIMENSIONS][BOARD_DIMENSIONS];

    /* Initialize the game board to ' ' (spaces). Thus, a space will mean the cell has not been
       taken yet    */  
    private void initBoard() {

    }

    /* Set the correct token at the location that the player clicked */
    // I don't think we need to check if the space has been taken here because
    // the button will disappear once the space is taken so the player can't really
    // access a used spot 
    void setToken(int row, int col) {

    }

    // randomly finds an empty space for the computer to place its move
    public int[] getComputerMoveArray() {
        int computerRow = 0;
        int computerCol = 0;

        return new int[]{computerRow, computerCol};

    }


    // some type of function(s) to check for wins and ties
    public boolean winAchieved() {
        return false;
    }

    public boolean tieAchieved() {
        return false;
    }


    
}
