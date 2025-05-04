package combat;

public class Enemy
{
    private int hp;
    private int attack;
    private int defense;
    private int xpReward;

    public Enemy(int hp, int attack, int defense, int xpReward)
    {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.xpReward = xpReward;
    }

    public void takeDamage(int amount)
    {
        hp -= amount;
        if(hp <= 0)
            hp = 0;
    }

    public boolean isDead()
    {
        boolean lifeStatus = false;

        if(hp == 0)
            lifeStatus = true;

        return lifeStatus;
    }

    public void printStatus() {
        System.out.println("Enemy - HP: " + hp +
                " | ATK: " + attack +
                " | DEF: " + defense +
                " | XP: " + xpReward);
    }


    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getXpReward()
    {
        return xpReward;
    }

    public void setXpReward(int xpReward)
    {
        this.xpReward = xpReward;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }
}
