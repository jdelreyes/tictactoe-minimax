//First Name: Jerome
//Last Name: Delos Reyes
//Student ID: 101324620

//First Name: Berniel
//Last Name: Francisco
//Student ID: 101388202

// First Name: Zoe
//Last Name: Detlefsen
//Student ID: 101176144

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String difficulty, turnOrder, opponentName = "";
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

        if (difficulty.equals("3")) {
            System.out.println("Please Enter Opponent's Name");
            System.out.print("\t > ");
            opponentName = scanner.nextLine();
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

        TicTacToe ticTacToe = new TicTacToe(playerName, playerSymbol, opponentSymbol);


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
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
                System.out.println("OPPONENT TURN (" + opponentSymbol + ")");

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
                System.out.println("OPPONENT TURN (" + opponentSymbol + ")");

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
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
                System.out.println("OPPONENT TURN (" + opponentSymbol + ")");

                ticTacToe.IntelligentAiMove();

                System.out.println("--------------------------------------------");
                System.out.println(ticTacToe.printBoard());

                if (ticTacToe.isWinning()) {
                    System.out.println(opponentName + " WON!");
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
                System.out.println("OPPONENT TURN (" + opponentSymbol + ")");

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
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
            while (true) {
                while (true) {
                    try {
                        System.out.println("--------------------------------------------");
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
                // HUMAN OPPONENT TURN
                while (true) {
                    try {
                        System.out.println("--------------------------------------------");
                        System.out.println("OPPONENT TURN (" + opponentSymbol + ")");
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

                        ticTacToe.opponentPlayerMove(row, column);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println(opponentName + " WON!");
                    break;
                }

                // since if someone is winning is checked, we can say that if the board is full, it's a draw
                if (ticTacToe.isBoardFull()) {
                    System.out.println("DRAW!");
                    break;
                }
            }
        }
        if (turnOrder.equals("2") && difficulty.equals("3")) {
            while (true) {
                // HUMAN OPPONENT TURN
                while (true) {
                    try {
                        System.out.println("--------------------------------------------");
                        System.out.println("OPPONENT TURN (" + opponentSymbol + ")");
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

                        ticTacToe.opponentPlayerMove(row, column);

                        System.out.println("--------------------------------------------");
                        System.out.println(ticTacToe.printBoard());

                        break;
                    } catch (Exception e) {
                        System.out.println("--------------------------------------------");
                        System.out.println("FAILED: Please Enter a Valid Move");
                    }
                }

                if (ticTacToe.isWinning()) {
                    System.out.println(opponentName + " WON!");
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
                        System.out.println("PLAYER TURN (" + ticTacToe.getPlayer().getPlayerSymbol() + ")");
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
            }
        }
    }
}
