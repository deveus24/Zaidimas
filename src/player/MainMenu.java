package player;

import java.io.IOException;
import java.util.Scanner;
import map.MapGenerator;
import map.MapIO;

public class MainMenu
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit)
        {
            printMenu();
            System.out.println("Choose operation: ");
            String input = scanner.nextLine();

            switch(input){
                case "1":
                    //TODO: start game logic
                    System.out.println("Starting game...");
                    break;

                case "2":
                    System.out.println("Generating new level...");
                    MapGenerator gen = new MapGenerator();
                    int width = 10, height = 5;
                    double enemyProb = 0.1, lootProb = 0.05;
                    char[][] map = gen.generate(width, height, enemyProb, lootProb);
                    for (char[] row : map)
                    {
                        System.out.println(new String(row));
                    }
                    MapIO.saveMap(map, "resources/maps/level1.csv");
                    break;

                case "3":
                    System.out.println("Importing level from file...");
                    try {
                        char[][] importedMap = MapIO.loadMap("resources/maps/level1.csv");
                        for (char[] row : importedMap) {
                            System.out.println(new String(row));
                        }
                    } catch (IOException e) {
                        System.out.println("Klaida importuojant lygi: " + e.getMessage());
                    }
                    break;

                case "4":
                    // TODO: show top 100 players and export to html
                    System.out.println("Top 100 players");
                    break;

                case "0":
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid input");
            }
            System.out.println();
        }
        scanner.close();
    }
    private static void printMenu()
    {
        System.out.println("Main menu");
        System.out.println("1. Start game");
        System.out.println("2. Generate new level");
        System.out.println("3. Importing new level");
        System.out.println("4. Top 100 players");
        System.out.println("0. Exit");
    }
}
