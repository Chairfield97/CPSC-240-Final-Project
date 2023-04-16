import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
//        new NameGUI();

        //Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance();
        ItemGenerator.itemSelection("Items.txt");
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);
        Inventory inventory = new Inventory(carryLimit);
        //for (int i = 0; i < 1; i++) {
        //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        p.addArmor(inventory.getEquippedArmor());
        System.out.println(p.getName() + ": " + p.getVitality());
        EventList event = new EventList();
        ArrayList <Enemy> enemies = event.enemies();
        Battle b = new Battle();
        for (Enemy e : enemies) {
            b.fight(inventory, p, e,rng);
        }
//        Grizzly g = new Grizzly();
//        BattleGUI b = new BattleGUI(inventory, p, g, rng);
//        b.fight();

    }
}
