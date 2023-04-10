import java.util.Scanner;

public class Player {
    // singleton
    private static String name;
    private static int baseVitality;
    private static int actualVitality;
    private static Player theInstance;
    private Player(String name) {
        Player.name = name;
        baseVitality = 50;
    }
    public static synchronized Player instance(Scanner nameInput) {
        if (theInstance == null) {
            System.out.print("Enter the name of your character: ");
            String playName = nameInput.nextLine();
            theInstance = new Player(playName);
        }
        return theInstance;
    }
    public int getVitality(Item armor) {
        return baseVitality + armor.getStrength();
    }
    public String getName() {
        return name;
    }


    public void attack(Enemy e) {
            // will add this in after enemies are created
    }
    public void specAttack(Enemy e) {
            // will add this in after enemies are created
    }
}
