import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


// singleton
public class Player {
    String BLUE = "\u001B[34m";
    String GREEN = "\033[0;32m";
    String RESET = "\033[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    private int damDealt;
    private static String name;
    private static int vitality;
    private int credits;
    private static Player theInstance;
    private int specCooldown = 0;
    //constructor to get name,health,and money
    private Player(String name) {
        Player.name = name;
        vitality = 50;
        credits = 10;
    }
    // input your name
    public static synchronized Player instance() {
//        Scanner nameInput = new Scanner(System.in);
        if (theInstance == null) {
            String nameInput = JOptionPane.showInputDialog("What is your name traveler?");
            theInstance = new Player(nameInput);
        }
        return theInstance;
    }
    //  return max health plus the armor strength
    public int getMaxVitality(Item armor) {
        return 50 + armor.getStrength();
    }
    //return health and the armor strength
    public int addArmor(Item armor) {
        vitality = 50;
        return vitality += armor.getStrength();
    }
    //returns your health at the start and after you go into battle
    public void heal(int health, Item armor) {
        if (vitality + health > 50 + armor.getStrength()) {
            addArmor(armor);
        } else {
            vitality += health;
        }
    }
    // you can get bonus credits depending on the randomizer and returns bonus
    public int bonusCredits(Random rng) {
        int bonus = 0;
        int chance = rng.nextInt(1,4);
        if (chance != 1) {
            bonus = rng.nextInt(5,13);
            System.out.println(ANSI_YELLOW + "\nYou also found " + bonus + " credits!" + ANSI_RESET);
            credits += bonus;
        }
        return bonus;
    }
    //returns money
    public int getCredits() {
        return credits;
    }
    //return money and money added
    public int addCredits(int creds) {
       return credits += creds;
    }
    //remove money
    public int removeCredits(int creds) {
        return credits -= creds;
    }
    //return health
    public int getVitality() {

        return vitality;
    }
    // if the player dodges the Enemy attack
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) == 1) {
            return false;
        } else {
            vitality -= dam;
            return true;
        }
    }
    //return the name
    public String getName() {
        return name;
    }
    //return the damage dealt when you click the attack button
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
    //return the amount of damage that you dealt the enemy for special attack
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
            //int remCooldown = 3 - specCooldown;
            specCooldown++;
            return ("Special cooldown remaining: " + getSpecCooldown() + "\n");
        }

    }
    // to make sure you wait to click the special attack
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
