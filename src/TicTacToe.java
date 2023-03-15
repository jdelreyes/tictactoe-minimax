import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private Player player;
    private char aiSymbol;

    // creating a tic-tac-toe board
    public TicTacToe() {
        board = new char[][] {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        player = new Player();
    }

    // TODO: delete later
    public void createGame(String playerName, char playerSymbol, char aiSymbol) {
        player.setName(playerName);
        player.setPlayerSymbol(playerSymbol);
        this.aiSymbol = aiSymbol;
    }

    public void createGame(String playerName, char playerSymbol,
                           String aiType, char aiSymbol) {
        player.setName(playerName);
        player.setPlayerSymbol(playerSymbol);
    }

    // IDEA: this could be private and act as a helper function
    public boolean makeMove(int move) {
        if (move > 9 || move < 0) return true;
        switch (move) {
            case 1 -> {
                if (board[0][0] == 'X' || board[0][0] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[0][0] = player.getPlayerSymbol();
            }
            case 2 -> {
                if (board[0][1] == 'X' || board[0][1] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[0][1] = player.getPlayerSymbol();
            }
            case 3 -> {
                if (board[0][2] == 'X' || board[0][2] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[0][2] = player.getPlayerSymbol();
            }
            case 4 -> {
                if (board[1][0] == 'X' || board[1][0] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[1][0] = player.getPlayerSymbol();
            }
            case 5 -> {
                if (board[1][1] == 'X' || board[1][1] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[1][1] = player.getPlayerSymbol();
            }
            case 6 -> {
                if (board[1][2] == 'X' || board[1][2] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[1][2] = player.getPlayerSymbol();
            }
            case 7 -> {
                if (board[2][0] == 'X' || board[2][0] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[2][0] = player.getPlayerSymbol();
            }
            case 8 -> {
                if (board[2][1] == 'X' || board[2][1] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[2][1] = player.getPlayerSymbol();
            }
            case 9 -> {
                if (board[2][2] == 'X' || board[2][2] == 'O') {
                    System.out.println("The spot is already filled in!");
                    return true;
                }
                board[2][2] = player.getPlayerSymbol();
            }
        }
        System.out.println(printBoard());
        if (someoneWon()) {
            System.out.println("someone won(change this later)");
            return false;
        }
        return isFull();
    }

    // AI
    public boolean weakAIMove() {
        Random random = new Random();
        int column = random.nextInt(9) + 1;
        int row = random.nextInt(9) + 1;

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') return false;
            }
        }
        return true;
    }

    private boolean someoneWon() {
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
