package game;

import map.MapGenerator;
import player.Player;
import combat.Enemy;
import combat.CombatEngine;
import loot.LootItem;
import inventory.Inventory;
import store.Store;
import score.ScoreEntry;
import score.ScoreBoard;

import java.util.Scanner;

public class GameLoop {

    public static void startGame() {
        MapGenerator generator = new MapGenerator();
        int width = 10, height = 5;
        double enemyProb = 0.15, lootProb = 0.1;
        char[][] map = generator.generate(width, height, enemyProb, lootProb);

        int playerX = 0;
        int playerY = 0;
        Player player = new Player(100, 100, 10, 5, 1, 0);
        Store store = new Store();

        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            printMap(map, playerX, playerY);
            System.out.print("Enter move (up/down/left/right/store/inventory/exit): ");
            String move = scanner.nextLine().toLowerCase();

            switch (move) {
                case "up":
                    if (playerY > 0) playerY--;
                    break;
                case "down":
                    if (playerY < height - 1) playerY++;
                    break;
                case "left":
                    if (playerX > 0) playerX--;
                    break;
                case "right":
                    if (playerX < width - 1) playerX++;
                    break;
                case "store":
                    store.enterStore(player.getInventory());
                    continue;
                case "inventory":
                    player.getInventory().printInventory();
                    continue;
                case "exit":
                    playing = false;
                    continue;
                default:
                    System.out.println("Unknown command");
            }

            char tile = map[playerY][playerX];

            if (tile == 'E') {
                System.out.println("Enemy encountered! Starting combat...");
                Enemy enemy = new Enemy(40, 6, 3, 50);
                CombatEngine.fight(player, enemy);
                if (player.isDead()) {
                    System.out.println("You died. Game over.");
                    playing = false;
                } else {
                    player.printStatus();
                }
                map[playerY][playerX] = '.';
            } else if (tile == 'L') {
                System.out.println("You found loot!");
                LootItem loot = new LootItem("Potion", "Consumable", 5);
                player.getInventory().addItem(loot);
                System.out.println("You received: " + loot.getName() + " (" + loot.getType() + ")");
                map[playerY][playerX] = '.';
            }
        }

        if (!player.isDead()) {
            player.printStatus();
            System.out.print("Enter your name to save your score: ");
            String playerName = scanner.nextLine();
            ScoreEntry entry = new ScoreEntry(playerName, player.getLevel(), player.getXp());
            ScoreBoard.saveScore(entry);
        }
    }

    private static void printMap(char[][] map, int playerX, int playerY) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("P ");
                } else {
                    System.out.print(map[y][x] + " ");
                }
            }
            System.out.println();
        }
    }
}
