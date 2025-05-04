package player;

public class PlayerTest
{
    public static void main(String[] args)
    {
        Player player = new Player(100, 100, 10, 5, 1, 0);
        player.printStatus();

        System.out.println("Zaidejas gauna 30 zalos...");
        player.takeDamage(30);
        player.printStatus();

        System.out.println("Zaidejas gauna 120 XP....");
        player.gainXp(120);
        player.printStatus();

        System.out.println("Zaidejas gauna dar 100 XP....");
        player.gainXp(100);
        player.printStatus();

        System.out.println("Zaidejas gauna 200 XP....");
        player.gainXp(200);
        player.printStatus();
    }
}
