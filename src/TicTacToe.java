import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Player player;
    private char opponentSymbol;
    private String gameMode;

    // for printing purposes
    public TicTacToe() {
        board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

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

        int move = 0;

        do {
            move = random.nextInt(9) + 1;
        } while (!isAvailable(move));

        makeMove(move, opponentSymbol);
    }

    public void IntelligentAiMove() {

    }

    // optional for playing with another human player
    public void opponentPlayerMove(int move) {
        makeMove(move, opponentSymbol);
    }

    public void playerMove(int move) {
        makeMove(move, player.getPlayerSymbol());
    }

    private void makeMove(int move, char symbol) {
        int[] coordinates = getCoordinates(move);
        board[coordinates[0]][coordinates[1]] = symbol;
    }

    //VALIDATIONS////////////////////////////////////////////////////////////START
    public boolean isAvailable(int move) {
        int[] coordinates = getCoordinates(move);
        if (board[coordinates[0]][coordinates[1]] == 'X' || board[coordinates[0]][coordinates[1]] == 'O')
            return false;
        return true;
    }

    public boolean isValidMove(int move) {
        return move >= 1 && move <= 9;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') return false;
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

    private int[] getCoordinates(int move) {
        switch (move) {
            case 1 -> {
                return new int[]{0, 0};
            }
            case 2 -> {
                return new int[]{0, 1};
            }
            case 3 -> {
                return new int[]{0, 2};
            }
            case 4 -> {
                return new int[]{1, 0};
            }
            case 5 -> {
                return new int[]{1, 1};
            }
            case 6 -> {
                return new int[]{1, 2};
            }
            case 7 -> {
                return new int[]{2, 0};
            }
            case 8 -> {
                return new int[]{2, 1};
            }
            case 9 -> {
                return new int[]{2, 2};
            }
        }
        return new int[0];
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
