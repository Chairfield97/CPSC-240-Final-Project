import java.util.Random;
import java.util.Scanner;

public class Player {
    // singleton
    private static String name;
    private static int vitality;
    private static int actualVitality;
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
    public void damage(int dam) {
        vitality -= dam;
    }
    public String getName() {
        return name;
    }


    public void attack(Enemy e, Item weapon, Random rng) {
        System.out.println("Standard Attack");
        e.damage(weapon.getStrength() + rng.nextInt(0,3));
    }
    public void specAttack(Enemy e, Item weapon, Random rng) {
        System.out.println("Special Attack");
        e.damage(weapon.getStrength() + rng.nextInt(5,10));
    }
}
