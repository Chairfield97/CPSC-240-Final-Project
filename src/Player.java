import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


// singleton
public class Player {
    String BLUE = "\u001B[34m";
    String GREEN = "\033[0;32m";
    String RESET = "\033[0m";
    private int damDealt;
    private static String name;
    private static int vitality;
    private static Player theInstance;
    private String attackChoice;
    private int specCooldown = 0;
    private int remCooldown;
    private Player(String name) {
        Player.name = name;
        vitality = 50;
    }
    public static synchronized Player instance() {
//        Scanner nameInput = new Scanner(System.in);
        if (theInstance == null) {
            String nameInput = JOptionPane.showInputDialog("What is your name traveler?");
            theInstance = new Player(nameInput);
        }
        return theInstance;
    }
    public int addArmor(Item armor) {
        vitality = 50;
        return vitality += armor.getStrength();
    }
    public int getVitality() {

        return vitality;
    }
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) == 1) {
            return false;
        } else {
            vitality -= dam;
            return true;
        }
    }
    public String getName() {
        return name;
    }

    public String attack(Enemy e, Item weapon, Random rng) {
        damDealt = weapon.getStrength() + rng.nextInt(0,5);
        specCooldown++;
        if (e.damage(damDealt, rng)) {

            return("Standard Attack hits! -" + damDealt + "\n");
            //System.out.println(RESET);
        } else {

            return("The " + e.getType() + " dodged your standard attack!\n");
        }
    }
    public String specAttack(Enemy e, Item weapon, Random rng) {
        damDealt = weapon.getStrength() + rng.nextInt(5,12);
        if (specCooldown >= 3) {
            specCooldown = 0;
            if (e.damage(damDealt, rng)) {

                //System.out.println(RESET);
                return ("Special Attack hits!!! -" + damDealt + "\n");
            } else {

                return ("The " + e.getType() + " dodged your special attack!\n");
            }
        } else {
            remCooldown = 3 - specCooldown;
            specCooldown++;
            return ("Special cooldown remaining: " + getSpecCooldown() + "\n");
        }

    }
    public int getSpecCooldown() {
        if (specCooldown <= 3) {
            return 3 - specCooldown;
        } else {
            return 0;
        }
    }

//    public void brawl(Enemy e, Item weapon, Random rng, Scanner in) {
//        e.sleep();
//        System.out.println(getName() + ": " + getVitality());
//        System.out.println("Standard (a)ttack, (s)pecial attack or enter to skip");
//        attackChoice = in.nextLine();
//        if (attackChoice.contains("a")) {
//            specCooldown++;
//            attack(e, weapon, rng);
//        } else if (attackChoice.contains("s")) {
//            if (specCooldown >= 3) {
//                specCooldown = 0;
//                specAttack(e, weapon, rng);
//            } else {
//                remCooldown = 3 - specCooldown;
//                specCooldown++;
//                System.out.println(BLUE + "Special cooldown remaining: " + getSpecCooldown());
//                System.out.print(RESET);
//                attack(e, weapon, rng);
//            }
//        } else {
//            e.sleep();
//            System.out.println(getName() + " opted to attack the " + e.getType());
//            specCooldown++;
//        }
//    }
}
