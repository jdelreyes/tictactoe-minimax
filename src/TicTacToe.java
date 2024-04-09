import java.util.Random;

public class TicTacToe {
    private final char[][] board;
    private final Player player;
    private final char opponentSymbol;

    public TicTacToe(String playerName, char playerSymbol, char opponentSymbol) {
        board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        player = new Player();

        player.setName(playerName);
        player.setPlayerSymbol(playerSymbol);
        this.opponentSymbol = opponentSymbol;
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
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (isAvailable(row, col)) {
                    board[row][col] = opponentSymbol;
                    int score = minimax(0, false);
                    board[row][col] = ' ';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = row;
                        bestCol = col;
                    }
                }
            }
        }

        makeMove(bestRow, bestCol, opponentSymbol);
    }

    private int minimax(int depth, boolean isMaximizingPlayer) {
        if (isWinning()) {
            return isMaximizingPlayer ? -1 : 1;
        } else if (isBoardFull()) {
            return 0;
        }

        int bestScore = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (isAvailable(row, col)) {
                    char symbol = isMaximizingPlayer ? opponentSymbol : player.getPlayerSymbol();
                    board[row][col] = symbol;

                    if (isMaximizingPlayer) {
                        bestScore = Math.max(bestScore, minimax(depth + 1, false));
                    } else {
                        bestScore = Math.min(bestScore, minimax(depth + 1, true));
                    }

                    board[row][col] = ' ';
                }
            }
        }

        return bestScore;
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
    public boolean isAvailable(int row, int column) { return board[row][column] == ' '; }

    public boolean isValidMove(int row, int column) {
        return column >= 0 && column <= 2 && row >= 0 && row <= 2;
    }

    public boolean isBoardFull() {
        for (char[] chars : board) {
            for (int column = 0; column < board.length; column++) {
                if (chars[column] == ' ') return false;
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
        StringBuilder output = new StringBuilder("    0   1   2\n");
        for (int i = 0; i < 3; i++) {
            output.append("  +---+---+---+ \n");
            output.append(i);
            for (int j = 0; j < 3; j++) {
                output.append(" | ").append(this.board[i][j]);
            }
            output.append(" | \n");
        }
        output.append("  +---+---+---+ ");
        return output.toString();
    }
}
