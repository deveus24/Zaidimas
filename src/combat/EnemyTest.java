package combat;

public class EnemyTest
{
   public static void main(String[] args)
   {
       Enemy goblin = new Enemy(50,7,2,60);

       System.out.println("Goblin takes 30 damage");
       goblin.takeDamage(30);
       goblin.printStatus();

       System.out.println("Is dead? " + goblin.isDead());

       System.out.println("Goblin takes 25 more damage");
       goblin.takeDamage(25);
       goblin.printStatus();

       System.out.println("Is dead now? " + goblin.isDead());
   }
}
