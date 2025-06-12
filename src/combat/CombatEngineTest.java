package combat;

import player.Player;
import loot.LootItem;
import inventory.Inventory;
import score.ScoreEntry;
import score.ScoreBoard;

import java.util.Scanner;

public class CombatEngineTest {
    public static void main(String[] args) {
        Player player = new Player(100, 100, 10, 5, 1, 0);
        Enemy goblin = new Enemy(40, 6, 3, 50);

        CombatEngine.fight(player, goblin);

        player.printStatus();
        player.getInventory().printInventory();

        // Čia įrašom rezultatą į ScoreBoard
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name to save your score: ");
        String playerName = scanner.nextLine();

        ScoreEntry entry = new ScoreEntry(playerName, player.getLevel(), player.getXp());
        ScoreBoard.saveScore(entry);
    }
}
