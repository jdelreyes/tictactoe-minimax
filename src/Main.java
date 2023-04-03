import java.util.Scanner;

// TODO:

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String difficulty, turnOrder;
        char playerSymbol, opponentSymbol;
        int column, row;


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
            System.out.println("Please Choose Difficulty (1-2)");
            System.out.println("1 : Weak AI");
            System.out.println("2 : Intelligent AI");
            System.out.println("3 : Opponent Player");
            System.out.print("\t > ");
            difficulty = scanner.nextLine();

            if (difficulty.equals("1") || difficulty.equals("2") || difficulty.equals("3")) break;

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

        TicTacToe ticTacToe = new TicTacToe(playerName, playerSymbol, opponentSymbol, difficulty);


        // THE GAME STARTS
        System.out.println("--------------------------------------------");
        System.out.println(ticTacToe.printBoard());

        // PLAYER TURNS FIRST
        // player goes first against a weak computer opponent
        if (turnOrder.equals("1") && difficulty.equals("1")) {
            while (true) {
                while (true) {
                    try {
                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter the Column");
                        System.out.print("\t > ");

                        String columnInput = scanner.nextLine();

                        System.out.println("Please Enter the Row");
                        System.out.print("\t > ");
                        String rowInput = scanner.nextLine();

                        row = Integer.parseInt(rowInput);
                        column = Integer.parseInt(columnInput);

                        if (!ticTacToe.isValidMove(row, column)) throw new Exception();
                        if (!ticTacToe.isAvailable(row, column)) throw new Exception();

                        ticTacToe.playerMove(row, column);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println(ticTacToe.getPlayer().getName() + " WON!");
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
        if (turnOrder.equals("2") && difficulty.equals("1")) {
            while (true) {
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
                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter the Column");
                        System.out.print("\t > ");

                        String columnInput = scanner.nextLine();

                        System.out.println("Please Enter the Row");
                        System.out.print("\t > ");
                        String rowInput = scanner.nextLine();

                        row = Integer.parseInt(rowInput);
                        column = Integer.parseInt(columnInput);

                        if (!ticTacToe.isValidMove(row, column)) throw new Exception();
                        if (!ticTacToe.isAvailable(row, column)) throw new Exception();

                        ticTacToe.playerMove(row, column);

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
        if (turnOrder.equals("1") && difficulty.equals("2")) {
            while (true) {
                while (true) {
                    try {
                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter the Column");
                        System.out.print("\t > ");

                        String columnInput = scanner.nextLine();

                        System.out.println("Please Enter the Row");
                        System.out.print("\t > ");
                        String rowInput = scanner.nextLine();

                        row = Integer.parseInt(rowInput);
                        column = Integer.parseInt(columnInput);

                        if (!ticTacToe.isValidMove(row, column)) throw new Exception();
                        if (!ticTacToe.isAvailable(row, column)) throw new Exception();

                        ticTacToe.playerMove(row, column);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println(ticTacToe.getPlayer().getName() + " WON!");
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

                ticTacToe.IntelligentAiMove();

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
        if (turnOrder.equals("2") && difficulty.equals("2")) {
            while (true) {
                // OPPONENT TURN
                System.out.println("--------------------------------------------");
                System.out.println("OPPONENT TURN");

                ticTacToe.IntelligentAiMove();

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
                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN");
                        System.out.println("Please Enter the Column");
                        System.out.print("\t > ");

                        String columnInput = scanner.nextLine();

                        System.out.println("Please Enter the Row");
                        System.out.print("\t > ");
                        String rowInput = scanner.nextLine();

                        row = Integer.parseInt(rowInput);
                        column = Integer.parseInt(columnInput);

                        if (!ticTacToe.isValidMove(row, column)) throw new Exception();
                        if (!ticTacToe.isAvailable(row, column)) throw new Exception();

                        ticTacToe.playerMove(row, column);

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
        if (turnOrder.equals("1") && difficulty.equals("3")) {

        }
        if (turnOrder.equals("2") && difficulty.equals("3")) {

        }
    }
}
