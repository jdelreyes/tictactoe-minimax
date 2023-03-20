import java.util.Scanner;

// TODO: should take 2 user inputs for column and row instead of 1 and
//       automatically translate it to column and row

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String gameMode, turnOrder;
        char playerSymbol = ' ', opponentSymbol = ' ';
        int move;


        System.out.println("Welcome to The Tic-Tac-Toe Game Application!");
        System.out.println("--------------------------------------------");
        System.out.println("Please Enter Your Name");
        System.out.print("\t > ");
        String playerName = scanner.nextLine();

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Please Choose Your Preferred Symbol (1-2)");
            System.out.println("1 : O");
            System.out.println("2 : X");
            System.out.print("\t > ");
            String symbol = scanner.nextLine();

            if (symbol.equals("1")) {
                playerSymbol = 'O';
                opponentSymbol = 'X';
                break;
            }
            if (symbol.equals("2")) {
                playerSymbol = 'X';
                opponentSymbol = 'O';
                break;
            }

            System.out.println("--------------------------------------------");
            System.out.println("FAILED: Please Enter a Valid Choice");
        }

        // TODO: implement Minimax Algorithm for Intelligent AI
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Please Choose a Game Mode (1-2)");
            System.out.println("1 : Weak AI");
            System.out.println("2 : Intelligent AI");
            System.out.println("3 : Opponent Player");
            System.out.print("\t > ");
            gameMode = scanner.nextLine();

            if (gameMode.equals("1") || gameMode.equals("2") || gameMode.equals("3")) break;

            System.out.println("--------------------------------------------");
            System.out.println("FAILED: Please Enter a Valid Choice");
        }

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Please Enter The Turn Order (1-2)");
            System.out.println("1 : First Turn");
            System.out.println("2 : Second Turn");
            System.out.print("\t > ");
            turnOrder = scanner.nextLine();

            if (turnOrder.equals("1") || turnOrder.equals("2")) break;

            System.out.println("--------------------------------------------");
            System.out.println("FAILED: Please Enter a Valid Choice");
        }

        TicTacToe ticTacToe = new TicTacToe(playerName, playerSymbol, opponentSymbol, gameMode);


        // THE GAME STARTS
        System.out.println("--------------------------------------------");
        System.out.println(ticTacToe.printBoard());

        // PLAYER TURNS FIRST
        // player goes first against a weak computer opponent
        if (turnOrder.equals("1") && gameMode.equals("1")) {
            while (true) {
                // PLAYER TURN
                while (true) {
                    try {
                        move = 0;

                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter a Move");
                        System.out.print("\t > ");
                        String userInput = scanner.nextLine();

                        move = Integer.parseInt(userInput);

                        if (!ticTacToe.isValidMove(move)) throw new Exception();
                        if (!ticTacToe.isAvailable(move)) throw new Exception();

                        ticTacToe.playerMove(move);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println("PLAYER WON!");
                    break;
                }

                // since if someone is winning is checked, we can say that if the board is full, it's a draw
                if (ticTacToe.isBoardFull()) {
                    System.out.println("DRAW!");
                    break;
                }

                // OPPONENT TURN
                System.out.println("--------------------------------------------");
                System.out.println("OPPONENT TURN");

                ticTacToe.weakAIMove();

                System.out.println("--------------------------------------------");
                System.out.println(ticTacToe.printBoard());

                if (ticTacToe.isWinning()) {
                    System.out.println("COMPUTER WON!");
                    break;
                }

                // since if someone is winning is checked, we can say that if the board is full, it's a draw
                if (ticTacToe.isBoardFull()) {
                    System.out.println("DRAW!");
                    break;
                }
            }
        }
        // OPPONENT TURNS FIRST
        // player goes second against a weak computer opponent
        if (turnOrder.equals("2") && gameMode.equals("1")) {
            while (true){
                // OPPONENT TURN
                System.out.println("--------------------------------------------");
                System.out.println("OPPONENT TURN");

                ticTacToe.weakAIMove();

                System.out.println("--------------------------------------------");
                System.out.println(ticTacToe.printBoard());

                if (ticTacToe.isWinning()) {
                    System.out.println("COMPUTER WON!");
                    break;
                }

                // since if someone is winning is checked, we can say that if the board is full, it's a draw
                if (ticTacToe.isBoardFull()) {
                    System.out.println("DRAW!");
                    break;
                }

                // PLAYER TURN
                while (true) {
                    try {
                        move = 0;

                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter a Move");
                        System.out.print("\t > ");
                        String userInput = scanner.nextLine();

                        move = Integer.parseInt(userInput);

                        if (!ticTacToe.isValidMove(move)) throw new Exception();
                        if (!ticTacToe.isAvailable(move)) throw new Exception();

                        ticTacToe.playerMove(move);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println("PLAYER WON!");
                    break;
                }

                // since if someone is winning is checked, we can say that if the board is full, it's a draw
                if (ticTacToe.isBoardFull()) {
                    System.out.println("DRAW!");
                    break;
                }
            }
        }
        if (turnOrder.equals("1") && gameMode.equals("2")) {

        }
        if (turnOrder.equals("2") && gameMode.equals("2")) {

        }
        if (turnOrder.equals("1") && gameMode.equals("3")) {

        }
        if (turnOrder.equals("2") && gameMode.equals("3")) {

        }
    }
}
