import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance(playerInput);
        ItemGenerator.itemSelection("Items.txt");
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);
        Inventory inventory = new Inventory(carryLimit);
        //for (int i = 0; i < 1; i++) {
        //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        p.addArmor(inventory.getEquippedArmor());
        System.out.println(p.getName() + ": " + p.getVitality());
        Battle b = new Battle();
        b.fight(inventory, p, playerInput, rng);

    }
}
