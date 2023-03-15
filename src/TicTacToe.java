import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Player player;
    private char aiSymbol;
    private String aiMode;

    // creating a tic-tac-toe board
    public TicTacToe(String playerName, char playerSymbol, char aiSymbol, String aiMode) {
        board = new char[][] {
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
    public boolean isAvailable(int move) {
        int[] coordinate = coordinates(move);
        if (board[coordinate[0]][coordinate[1]] == 'X' || board[coordinate[0]][coordinate[1]] == 'O')
            return false;
        return true;
    }

    // AI
    public boolean weakAIMove() {
        Random random = new Random();
        int column = random.nextInt(9) + 1;
        int row = random.nextInt(9) + 1;



        return false;
    }

    public boolean playerMove(int move) {
        if (move > 9 || move < 0) {
            System.out.println("Please enter a valid move");
            return true;
        }
        if (!isAvailable(move)) {
            System.out.println("Please enter a move to unoccupied spot");
            return true;
        }
        makeMove(move, player.getPlayerSymbol());
        if (winning()) {
            System.out.println("someone won (change later)");
            return false;
        }
        if (isFull()) return false;
        return true;
    }

    private int[] coordinates(int move) {
        switch (move) {
            case 1 -> {
                return new int[] {0, 0};
            }
            case 2 -> {
                return new int[] {0, 1};
            }
            case 3 -> {
                return new int[] {0, 2};
            }
            case 4 -> {
                return new int[] {1, 0};
            }
            case 5 -> {
                return new int[] {1, 1};
            }
            case 6 -> {
                return new int[] {1, 2};
            }
            case 7 -> {
                return new int[] {2, 0};
            }
            case 8 -> {
                return new int[] {2, 1};
            }
            case 9 -> {
                return new int[] {2, 2};
            }
            default -> {
                return new int[] {-1, -1};
            }
        }
    }

    public void makeMove(int move, char symbol) {
        int[] coordinate = coordinates(move);
        board[coordinate[0]][coordinate[1]] = symbol;
        System.out.println(printBoard());
    }

    private boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') return false;
            }
        }
        return true;
    }

    private boolean winning() {
        return (board[0][0] == board [0][1] && board[0][0] == board [0][2]) ||
                (board[0][0] == board [1][1] && board[0][0] == board [2][2]) ||
                (board[0][0] == board [1][0] && board[0][0] == board [2][0]) ||
                (board[2][0] == board [2][1] && board[2][0] == board [2][2]) ||
                (board[2][0] == board [1][1] && board[2][0] == board [0][2]) ||
                (board[0][2] == board [1][2] && board[0][2] == board [2][2]) ||
                (board[0][1] == board [1][1] && board[0][1] == board [2][1]) ||
                (board[1][0] == board [1][1] && board[1][0] == board [1][2]);
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
