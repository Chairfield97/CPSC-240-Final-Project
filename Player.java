import java.util.Scanner;

public class Player {
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
    public int getVitality() {
        return vitality;
    }
    public String getName() {
        return name;
    }

    //public void attack(Enemy e) {
            // will add this in after enemies are created
    //}
    //public void specAttack(Enemy e) {
            // will add this in after enemies are created
    //}
}
