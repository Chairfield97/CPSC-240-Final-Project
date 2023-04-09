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
        System.out.print(p.getName() + "\n");
        System.out.print(p.getVitality() + "\n");
        System.out.println("Starting Weapon: " + inventory.getEquippedWeapon());
        System.out.println("Starting Armor: " + inventory.getEquippedArmor());
        for ( int i = 0; i < 5; i++) {
            inventory.add(ItemGenerator.generate());
        }
        inventory.print();
    }
}
