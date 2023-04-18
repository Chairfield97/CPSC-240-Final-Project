import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class Battle {

    private Enemy enemy;
    private Player player;
    private Inventory inventory;
    private Random rng;
    EventList eventList = new EventList();


    public Battle(Inventory inventory, Player player, Random rng) {
        this.enemy = eventList.enemySpawn(rng);
        this.player= player;
        this.inventory = inventory;
        this.rng = rng;
        fight();
    }

    public void fight() {
        if (this.enemy != null) {
            new BattleGUI(inventory, player, enemy, rng);
        } else {
            System.out.println("You've completed your journey " + player.getName());
            System.exit(0);
        }
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
