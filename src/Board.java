public class Board {
    private char[][] board;
    private Player player;

    // creating a tic-tac-toe board
    public Board() {
        // delete this and symbols later. for printing purposes [0][0] to [2][2]
        board = new char[][] {{'X', 'O', 'X'},{'O', 'X', 'O'},{'X', 'O', 'X'}};
    }

    public boolean makeMove(int move) {
        switch (move) {
            case 1:
                board[0][0] = player.getPlayerSymbol();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
        }
        return false;
    }

    // the 2 functions below add moves to the board
    // can be removed later
    public boolean moveX(int column, int row) {
        return false;
    }

    public boolean moveO(int column, int row) {
        return false;
    }

    public String printBoard() {
        String output = "";
        for (int i = 0; i < 3; i++) {
            output +=  " ------------- \n";
            for (int j = 0; j < 3; j++) {
                output += " | " + this.board[i][j];
            }
            output += " |\n";
        }
        output += " ------------- ";
        return output;
    }
}
