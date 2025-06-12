package player;

import inventory.Inventory;
import loot.LootItem;

public class Player
{
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int level;
    private int xp;
    private Inventory inventory;

    public Player(int hp, int maxHp, int attack, int defense, int level, int xp)
    {
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.xp = xp;
        this.inventory = new Inventory();
    }

    public void takeDamage(int damage)
    {
        hp -= damage;
        if(hp < 0)
            hp = 0;
    }

    public boolean isDead()
    {
        boolean lifeStatus = false;

        if(hp == 0)
            lifeStatus = true;

        return lifeStatus;
    }

    public void gainXp(int amount)
    {
        xp += amount;
        int requiredXp;
        while (true)
        {
            requiredXp = level * 100;
            if (xp >= requiredXp)
            {
                xp -= requiredXp;
                levelUp();
            }
            else
            {
                break;
            }
        }
    }



    public void printStatus()
    {
        System.out.println("Player - HP: " + hp + "/" + maxHp +
                "| ATK: " + attack +
                "| DEF: " + defense +
                "| LVL: " + level +
                "| XP: " + xp);
    }

    private void levelUp()
    {
        level++;
        maxHp += 20;
        hp = maxHp;
        attack += 2;
        defense += 1;
        System.out.println("Level up! Current level: " + level);

        checkAchievements();
    }

    private void checkAchievements() {
        switch (level) {
            case 5:
                System.out.println("🏆 Achievement unlocked: Reached level 5!");
                break;
            case 10:
                System.out.println("🏆 Achievement unlocked: Reached level 10!");
                break;
            case 20:
                System.out.println("🏆 Achievement unlocked: Reached level 20!");
                break;
            default:
                break;
        }
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void setMaxHp(int maxHp)
    {
        this.maxHp = maxHp;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getXp()
    {
        return xp;
    }

    public void setXp(int xp)
    {
        this.xp = xp;
    }

}
