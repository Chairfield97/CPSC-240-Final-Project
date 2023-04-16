import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Player p = Player.instance();
        ItemGenerator.itemSelection("Items.txt");    //passes import file to be imported
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);   //generates random carry limit
        Inventory inventory = new Inventory(carryLimit);    //passes carry limit to inventory
        Scanner input = new Scanner(System.in);
        boolean prompt = true;
        int userSelection;
        while (prompt) {    //while player does not select exit

            System.out.println("\n" + p.getName());
            System.out.println("Vitality: " + p.addArmor(inventory.getEquippedArmor()));
            System.out.println("Carry Capacity : " + inventory.totalWeight() + "/" + carryLimit);
            System.out.println(" \nArmor:  " + inventory.getEquippedArmor() + "\n" + "Weapon: " + inventory.getEquippedWeapon());
            System.out.println("-------------------------");
            System.out.println("1. Battle");
            System.out.println("2. Print Inventory");
            System.out.println("3. Add random item");
            System.out.println("4. Drop item");
            System.out.println("5. Equip weapon");
            System.out.println("6. Equip armor");
            System.out.println("7. Exit");
            System.out.print(": ");


            userSelection = input.nextInt();    //scans users input
            System.out.println();
            switch (userSelection) {
                case 1:
                    new Battle(inventory, p, rng);
                    break;
                case 2:     //print inventory choice
                    inventory.print();
                    break;
                case 3:     //add random item choice
                    inventory.add(ItemGenerator.generate());
                    break;
                case 4:     //drop item choice
                    inventory.drop();
                    break;
                case 5:     //equip weapon choice
                    inventory.equipWeapon();
                    break;
                case 6:     //equip armor choice
                    inventory.equipArmor();
                    break;
                case 7:     //exit out
                    System.out.println("Good luck on your journey " + p.getName());
                    prompt = false;
            }
        }
    }
}
