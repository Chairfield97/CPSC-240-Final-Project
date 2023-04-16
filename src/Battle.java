import java.util.ArrayList;
import java.util.Random;


public class Battle {

    private Enemy enemy;
    private Player player;
    private Inventory inventory;
    private Random rng;
    EventList event = new EventList();
    ArrayList<Enemy> enemies = event.enemies();

    public Battle(Inventory inventory, Player player, Random rng) {
        this.enemy = enemies.remove(rng.nextInt(0, enemies.size()));
        this.player= player;
        this.inventory = inventory;
        this.rng = rng;
        fight();
    }

    public void fight() {
        BattleGUI b = new BattleGUI(inventory, player, enemy, rng);



//
//        do {
//            p.brawl(enemy, inventory.getEquippedWeapon(), rng, playerInput);
//            if (enemy.getVitality() > 0) {
//                enemy.brawl(p, rng);
//            }
//        } while (p.getVitality() > 0 && enemy.getVitality() > 0);
//
//        if (p.getVitality() <= 0) {
//            enemy.sleep();
//            System.out.println(p.getName() + " was defeated by " + enemy.getType());
//        } else {
//            enemy.sleep();
//            System.out.println(p.getName() + " defeated the " + enemy.getType());
//        }
    }
}
