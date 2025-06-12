package game;

import score.ScoreBoard;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Start New Game");
            System.out.println("2. Show Top Players");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    GameLoop.startGame();
                    break;
                case "2":
                    ScoreBoard.printTopScores();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting game...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
