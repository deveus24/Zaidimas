package combat;

import player.Player;
import loot.LootItem;
import inventory.Inventory;

public class CombatEngine
{
    public static void fight(Player player, Enemy enemy)
    {
        while(!player.isDead() && !enemy.isDead())
        {
            int damage = 0;

            damage = Math.max(0, player.getAttack() - enemy.getDefense());
            enemy.takeDamage(damage);
            System.out.println("Enemy has taken " + damage + " damage");

            if(enemy.isDead())
                break;

            damage = Math.max(0, enemy.getAttack() - player.getDefense());
            player.takeDamage(damage);

            System.out.println("Player has taken " + damage + " damage");
        }

        if(!player.isDead())
        {
            System.out.println("Enemy has been defeated");
            System.out.println("You have received " + enemy.getXpReward() + " XP");
            player.gainXp(enemy.getXpReward());


            LootItem loot = new LootItem("Sword", "Weapon", 15);
            player.getInventory().addItem(loot);
            System.out.println("You received loot: ");
            loot.printInfo();
        }
        else
        {
            System.out.println("You lost");
        }
    }
}
