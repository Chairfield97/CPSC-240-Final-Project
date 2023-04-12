import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance(playerInput);
        ItemGenerator.itemSelection("Items.txt");
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);
        Inventory inventory = new Inventory(carryLimit);
        p.addArmor(inventory.getEquippedArmor());
        System.out.println(p.getName() + ": " + p.getVitality());
        System.out.println("Starting Weapon: " + inventory.getEquippedWeapon());
        System.out.println("Starting Armor: " + inventory.getEquippedArmor() + "\n");
        //for ( int i = 0; i < 5; i++) {
            //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        Grizzly g = new Grizzly();
        g.Image();

        do {
            System.out.println(g.getType() + ": " + g.getVitality());
            g.attack(p, rng);
            System.out.println(p.getName() + ": " + p.getVitality());
            p.attack(g, inventory.getEquippedWeapon(), rng);
            System.out.println(g.getType() + ": " + g.getVitality());
            g.specAttack(p, rng);
            System.out.println(p.getName() + ": " + p.getVitality());
            p.specAttack(g, inventory.getEquippedWeapon(), rng);
            //System.out.println(g.getType() + ": " + g.getVitality());
        } while (p.getVitality() > 0 && g.getVitality() > 0);

        if (p.getVitality() <= 0) {
            System.out.println(p.getName() + " defeated by " + g.getType());
        } else {
            System.out.println(p.getName() + " defeated the " + g.getType());
        }
    }
}
