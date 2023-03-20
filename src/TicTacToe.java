import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Player player;
    private char opponentSymbol;
    private String gameMode;

    public TicTacToe(String playerName, char playerSymbol, char opponentSymbol, String gameMode) {
        board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        player = new Player();

        player.setName(playerName);
        player.setPlayerSymbol(playerSymbol);
        this.opponentSymbol = opponentSymbol;
        this.gameMode = gameMode;
    }

    public void weakAIMove() {
        Random random = new Random();

        int column, row;

        do {
            row = (random.nextInt(3) + 1) - 1;
            column = (random.nextInt(3) + 1) - 1;
        } while (!isAvailable(row, column));

        makeMove(row, column, opponentSymbol);
    }

    public void IntelligentAiMove() {

    }

    // optional for playing with another human player
    public void opponentPlayerMove(int row, int column) {
        makeMove(row, column, opponentSymbol);
    }

    public void playerMove(int row, int column) {
        makeMove(row, column, player.getPlayerSymbol());
    }

    private void makeMove(int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    //VALIDATIONS////////////////////////////////////////////////////////////START
    public boolean isAvailable(int row, int column) {
        if (board[row][column] == ' ')
            return true;
        return false;
    }

    public boolean isValidMove(int row, int column) {
        return column >= 0 && column <= 2 && row >= 0 && row <= 2;
    }

    public boolean isBoardFull() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] != 'X' && board[row][column] != 'O') return false;
            }
        }
        return true;
    }
    //VALIDATIONS////////////////////////////////////////////////////////////END

    public boolean isWinning() {
        return (board[0][0] == board[0][1]
                        && board[0][0] == board[0][2]
                        && board[0][0] != ' ' ) ||
                (board[0][0] == board[1][1]
                        && board[0][0] == board[2][2]
                        && board[0][0] != ' ') ||
                (board[0][0] == board[1][0]
                        && board[0][0] == board[2][0]
                        && board[0][0] != ' ') ||
                (board[2][0] == board[2][1]
                        && board[2][0] == board[2][2]
                        && board[2][0] != ' ') ||
                (board[2][0] == board[1][1]
                        && board[2][0] == board[0][2]
                        && board[2][0] != ' ') ||
                (board[0][2] == board[1][2]
                        && board[0][2] == board[2][2]
                        && board[0][2] != ' ') ||
                (board[0][1] == board[1][1]
                        && board[0][1] == board[2][1]
                        && board[0][1] != ' ') ||
                (board[1][0] == board[1][1]
                        && board[1][0] == board[1][2]
                        && board[1][0] != ' ');
    }

    public Player getPlayer() {
        return player;
    }

    public String printBoard() {
        String output = "    0   1   2\n";
        for (int i = 0; i < 3; i++) {
            output += "  +---+---+---+ \n";
            output += i;
            for (int j = 0; j < 3; j++) {
                output += " | " + this.board[i][j];
            }
            output += " | \n";
        }
        output += "  +---+---+---+ ";
        return output;
    }
}
