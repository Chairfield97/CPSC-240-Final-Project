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
        System.out.println("Starting Armor: " + inventory.getEquippedArmor());
        //for ( int i = 0; i < 5; i++) {
            //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        Boar b = new Boar();
        b.Image();
        do {
            System.out.println(b.getType() + ": " + b.getVitality());
            b.attack(p, rng);
            System.out.print(p.getName() + ": " + p.getVitality() + "\n");
            p.attack(b, inventory.getEquippedWeapon(), rng);
            System.out.println(b.getType() + ": " + b.getVitality());
            b.specAttack(p, rng);
            System.out.print(p.getName() + ": " + p.getVitality() + "\n");
            p.specAttack(b, inventory.getEquippedWeapon(), rng);
            System.out.println(b.getType() + ": " + b.getVitality());
        } while (p.getVitality() > 0 && b.getVitality() > 0);
        if (p.getVitality() == 0) {
            System.out.println(p.getName() + " defeated by " + b.getType());
        } else {
            System.out.println(p.getName() + " defeated the " + b.getType());
        }
    }
}
