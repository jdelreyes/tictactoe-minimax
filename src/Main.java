import java.util.Scanner;

// TODO:

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

        // TODO: intelligent AI
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Please Choose a Game Mode (1-2)");
            System.out.println("1 : Weak AI");
            System.out.println("2 : Intelligent AI");
            System.out.print("\t > ");
            gameMode = scanner.nextLine();

            if (gameMode.equals("1") || gameMode.equals("2")) break;

            System.out.println("--------------------------------------------");
            System.out.println("FAILED: Please Enter a Valid Choice");
        }

        while(true) {
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

        while (true) {
            if (turnOrder.equals("1")) {
                System.out.println("--------------------------------------------");
                System.out.println(ticTacToe.printBoard());

                System.out.println("--------------------------------------------");
                System.out.print("Please make a move: ");
                move = scanner.nextInt();
                if (!ticTacToe.playerMove(move)) break;
                System.out.println("--------------------------------------------");
                System.out.println("AI MOVE");
                if (!ticTacToe.weakAIMove()) break;
            }
            if (turnOrder.equals("2")) {
                System.out.println("--------------------------------------------");
                System.out.println("AI MOVE");
                if (!ticTacToe.weakAIMove()) break;
                System.out.println("--------------------------------------------");
                System.out.print("Please make a move: ");
                move = scanner.nextInt();
                if (!ticTacToe.playerMove(move)) break;
            }
        }
    }
}