package src;

import java.util.Random;
import java.util.Scanner;

public class Player {
    // singleton
    private static String name;
    private static int vitality;
    private static Player theInstance;
    private Player(String name) {
        Player.name = name;
        vitality = 50;
    }
    public static synchronized Player instance(Scanner nameInput) {
        if (theInstance == null) {
            System.out.print("Enter the name of your character: ");
            String playName = nameInput.nextLine();
            theInstance = new Player(playName);
        }
        return theInstance;
    }
    public void addArmor(Item armor) {
        vitality += armor.getStrength();
    }
    public int getVitality() {
        return vitality;
    }
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) == 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }
    public String getName() {
        return name;
    }

    public void attack(Enemy e, Item weapon, Random rng) {
        if (e.damage(weapon.getStrength() + rng.nextInt(0,3), rng)) {
            System.out.println("Standard Attack hits!");
        } else {
            System.out.println("The " + e.getType() + " dodged the standard attack!");
        }
    }
    public void specAttack(Enemy e, Item weapon, Random rng) {
        if (e.damage(weapon.getStrength() + rng.nextInt(5,10), rng)) {
            System.out.println("Special Attack hits!!!");
        } else {
            System.out.println("The " + e.getType() + " dodged the special attack!");
        }
    }
}
