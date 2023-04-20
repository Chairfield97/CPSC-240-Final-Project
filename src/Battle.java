import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
// For the player and Enemy to battle
public class Battle {

    private Enemy enemy;
    private Player player;
    private Inventory inventory;
    private Random rng;
    private boolean finished;
    EventList eventList = new EventList();
    BattleGUI b;
    //Battle Constuctor what it is supposed to print out
    public Battle(Inventory inventory, Player player, Random rng) {
        this.enemy = eventList.enemySpawn(rng);
        this.player= player;
        this.inventory = inventory;
        this.rng = rng;
        this.finished = false;
    }
    // returns if the battle is true
    public boolean finished() {
        return this.finished;
    }
    //returns the battle and used the BattleGui
    public boolean fight() {
        if (this.enemy != null) {

            BattleGUI b = new BattleGUI (inventory, player, enemy, rng);

//            boolean concluded;
//            do {
//                concluded = b.getConclusion();
//
//            }
//            while (!concluded);
            this.finished = b.getConclusion();


            return true;

        } else {
            System.out.println("You've completed your journey " + player.getName());
            System.exit(0);

            return this.finished;
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
