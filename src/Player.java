import java.util.Random;
import java.util.Scanner;

// singleton
public class Player {
    String GREEN = "\033[0;32m";
    String RESET = "\033[0m";
    private int damDealt;
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
        if (rng.nextInt(0,3) == 1) {
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
        damDealt = weapon.getStrength() + rng.nextInt(0,3);
        if (e.damage(damDealt, rng)) {
            System.out.println(GREEN + "Standard Attack hits! - " + damDealt);
            System.out.println(RESET);
        } else {
            System.out.println("The " + e.getType() + " dodged your standard attack!\n");
        }
    }
    public void specAttack(Enemy e, Item weapon, Random rng) {
        damDealt = weapon.getStrength() + rng.nextInt(5,10);
        if (e.damage(damDealt, rng)) {
            System.out.println(GREEN + "Special Attack hits!!! - " + damDealt);
            System.out.println(RESET);
        } else {
            System.out.println("The " + e.getType() + " dodged your special attack!\n");
        }
    }
}
