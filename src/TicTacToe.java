public class TicTacToe {
    private char[][] board;
    private Player player;

    // creating a tic-tac-toe board
    public TicTacToe() {
        // delete this and symbols later. for printing purposes [0][0] to [2][2]
        board = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        player = new Player();
    }

    public void createPlayer(String name, char playerSymbol) {
        player.setName(name);
        player.setPlayerSymbol(playerSymbol);
    }

    public boolean makeMove(int move) {
        if (isFull()) return false;
        if (move > 9 || move < 0) return true;
        switch (move) {
            case 1:
                if (board[0][0] != ' ') return true;
                board[0][0] = player.getPlayerSymbol();
                break;
            case 2:
                if (board[0][1] != ' ') return true;
                board[0][1] = player.getPlayerSymbol();
                break;
            case 3:
                if (board[0][2] != ' ') return true;
                board[0][2] = player.getPlayerSymbol();
                break;
            case 4:
                if (board[1][0] != ' ') return true;
                board[1][0] = player.getPlayerSymbol();
                break;
            case 5:
                if (board[1][1] != ' ') return true;
                board[1][1] = player.getPlayerSymbol();
                break;
            case 6:
                if (board[1][2] != ' ') return true;
                board[1][2] = player.getPlayerSymbol();
                break;
            case 7:
                if (board[2][0] != ' ') return true;
                board[2][0] = player.getPlayerSymbol();
                break;
            case 8:
                if (board[2][1] != ' ') return true;
                board[2][1] = player.getPlayerSymbol();
                break;
            case 9:
                if (board[2][2] != ' ') return true;
                board[2][2] = player.getPlayerSymbol();
                break;
        }
        System.out.println(printBoard());
        return true;
    }

    // the 2 functions below add moves to the board
    // can be removed later
    public boolean moveX(int column, int row) {
        return false;
    }

    public boolean moveO(int column, int row) {
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
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
