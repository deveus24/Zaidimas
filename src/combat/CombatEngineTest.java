package combat;

import player.Player;

public class CombatEngineTest
{
    public static void main(String[] args)
    {
        Player player = new Player(100, 100, 10, 5, 1, 0);
        Enemy goblin = new Enemy(40, 6, 3, 50);

        CombatEngine.fight(player, goblin);
        player.printStatus();
    }
}
