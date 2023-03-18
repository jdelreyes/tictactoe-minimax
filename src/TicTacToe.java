import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Player player;
    private char aiSymbol;
    private String aiMode;

    public TicTacToe(String playerName, char playerSymbol, char aiSymbol, String aiMode) {
        board = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };

        player = new Player();

        player.setName(playerName);
        player.setPlayerSymbol(playerSymbol);
        this.aiSymbol = aiSymbol;
        this.aiMode = aiMode;
    }

    public boolean weakAIMove() {
        Random random = new Random();

        int move = random.nextInt(9) + 1;
        int moveCondition = makeMove(move, aiSymbol);

        while (moveCondition == -1 || moveCondition == -2) {
            move = random.nextInt(9) + 1;
            moveCondition = makeMove(move, aiSymbol);
        }

        if (moveCondition == -3) {
            System.out.println("The Opponent WON!");
            return false;
        }
        if (moveCondition == -4) {
            System.out.println("DRAW!");
            return false;
        }

        return moveCondition == -5;
    }

    public boolean playerMove(int move) {

        int moveCondition = makeMove(move, player.getPlayerSymbol());

        if (moveCondition == -1 || moveCondition == -2) {
            System.out.println("Please enter a valid number");
            return false;
        }
        if (moveCondition == -3) {
            System.out.println("The Player WON!");
            return false;
        }
        if (moveCondition == -4) {
            System.out.println("DRAW!");
            return false;
        }
        // if its valid
        return moveCondition == -5;
    }

    private int makeMove(int move, char symbol) {
        if (!isAvailable(move)) return -1;
        if (!isValidMove(move)) return -2;

        int[] coordinates = getCoordinates(move);
        board[coordinates[0]][coordinates[1]] = symbol;
        System.out.println(printBoard());

        if (isWinning()) return -3;
        if (isBoardFull()) return -4;

        return -5;
    }

    private boolean isValidMove(int move) {
        return move <= 9 && move >= 1;
    }

    private boolean isAvailable(int move) {
        int[] coordinates = getCoordinates(move);
        if (board[coordinates[0]][coordinates[1]] == 'X' || board[coordinates[0]][coordinates[1]] == 'O')
            return false;
        return true;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') return false;
            }
        }
        return true;
    }

    private boolean isWinning() {
        return (board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
                (board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
                (board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
                (board[2][0] == board[2][1] && board[2][0] == board[2][2]) ||
                (board[2][0] == board[1][1] && board[2][0] == board[0][2]) ||
                (board[0][2] == board[1][2] && board[0][2] == board[2][2]) ||
                (board[0][1] == board[1][1] && board[0][1] == board[2][1]) ||
                (board[1][0] == board[1][1] && board[1][0] == board[1][2]);
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
        String output = "";
        for (int i = 0; i < 3; i++) {
            output += " +---+---+---+ \n";
            for (int j = 0; j < 3; j++) {
                output += " | " + this.board[i][j];
            }
            output += " |\n";
        }
        output += " +---+---+---+ ";
        return output;
    }
}
