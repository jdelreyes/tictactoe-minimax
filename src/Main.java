import java.util.Scanner;

// TODO: use Random class to generate random integers for accessing the 2 dimensional array.
//      This helps us make an easy AI

public class Main {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        String aiType, choice;
        char playerSymbol = ' ', computerSymbol = ' ';
        int move;

        System.out.print("Please enter your name: ");
        String playerName = scanner.nextLine();

        do {
            System.out.println("-------------------------");
            System.out.println("Symbols: \nenter 0 for symbol:\tO\nenter 1 for symbol:\tX");
            System.out.print("Please choose a symbol: ");
            String symbol = scanner.nextLine();
            if (symbol.equals("0")) playerSymbol = 'O';
            if (symbol.equals("1")) playerSymbol = 'X';
        } while (playerSymbol != 'O' && playerSymbol != 'X');

        do {
            System.out.println("-------------------------");
            System.out.println("AI Type: \nenter 0 for:\tWeak AI\nenter 1 for:\tIntelligent AI");
            System.out.print("Please choose an AI: ");
            aiType = scanner.nextLine();
        } while (!aiType.equals("0") && !aiType.equals("1"));

        do {
            System.out.println("-------------------------");
            System.out.println("If you wish to play first, enter 0. Otherwise, enter 1");
            System.out.print("Please enter your choice: ");
            choice = scanner.nextLine();
        } while(!choice.equals("0") && !choice.equals("1"));

        ticTacToe.createPlayer(playerName, playerSymbol);

        System.out.println(ticTacToe.printBoard());

        do {
            System.out.print("Enter move(1-9): ");
            move = scanner.nextInt();
        } while (ticTacToe.makeMove(move));

    }
}