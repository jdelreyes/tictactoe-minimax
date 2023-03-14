import java.util.Scanner;

// IDEA: we can make another class called game that makes
// a student instance and a board instance

public class Main {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
//
        Board board = new Board();

        System.out.println(board.printBoard());

        System.out.print("Please enter your name: ");
        String playerName = stringScanner.nextLine();

        String symbol, aiType, choice;

        do {
            System.out.println("-------------------------");
            System.out.println("Symbols: \nenter 0 for symbol:\tO\nenter 1 for symbol:\tX");
            System.out.print("Please choose a symbol: ");
            symbol = stringScanner.nextLine();
        } while (!symbol.equals("0") && !symbol.equals("1"));

        do {
            System.out.println("-------------------------");
            System.out.println("AI Type: \nenter 0 for:\tWeak AI\nenter 1 for:\tIntelligent AI");
            System.out.print("Please choose an AI: ");
            aiType = stringScanner.nextLine();
        } while (!aiType.equals("0") && !aiType.equals("1"));

        do {
            System.out.println("-------------------------");
            System.out.println("If you wish to play first, enter 0. Otherwise, enter 1");
            System.out.print("Please enter your choice: ");
            choice = stringScanner.nextLine();
        } while(!choice.equals("0") && !choice.equals("1"));

    }
}