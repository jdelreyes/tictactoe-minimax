import java.util.Scanner;

// TODO: use Random class to generate random integers for accessing the 2 dimensional array.
//      This helps us make an easy AI
// TODO: the code messy, fix later

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        String aiType, choice;
        char playerSymbol = ' ', aiSymbol = ' ';
        int move;

        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();

        do {
            System.out.println("-------------------------");
            System.out.println("Symbols: \nenter 1 for symbol:\tO\nenter 2 for symbol:\tX");
            System.out.print("Please choose a symbol: ");
            String symbol = scanner.nextLine();
            if (symbol.equals("1")) {
                playerSymbol = 'O';
                aiSymbol = 'X';
            }
            if (symbol.equals("2")) {
                playerSymbol = 'X';
                aiSymbol = 'O';
            }
        } while (playerSymbol != 'O' && playerSymbol != 'X');

        do {
            System.out.println("-------------------------");
            System.out.println("AI Type: \nenter 1 for:\tWeak AI\nenter 2 for:\tIntelligent AI");
            System.out.print("Please choose an AI: ");
            aiType = scanner.nextLine();
        } while (!aiType.equals("1") && !aiType.equals("2"));

        do {
            System.out.println("-------------------------");
            System.out.println("If you wish to play first, enter 1. Otherwise, enter 2");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextLine();
        } while(!choice.equals("1") && !choice.equals("2"));

        ticTacToe.createGame(playerName, playerSymbol, aiSymbol);

        System.out.println(ticTacToe.printBoard());

        do {
            System.out.print("Enter move(1-9): ");
            move = scanner.nextInt();
        } while (ticTacToe.makeMove(move));

    }
}