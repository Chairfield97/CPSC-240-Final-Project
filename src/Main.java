import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //attempt at bringing the MainGUI in again
//        Player p = Player.instance();
//        new MainGUI(p);
        try {
            PrintWriter fileErase = new PrintWriter("Results.txt");
            fileErase.print("");
            fileErase.close();
        } catch (IOException e) {
            System.out.println("Unable to erase previous results");
        }
        EventList eventList = new EventList();
        Player player = Player.instance();
        ItemGenerator.itemSelection("Items.txt");    //passes import file to be imported
        Random rng = new Random();
        int carryLimit = rng.nextInt(70,111);   //generates random carry limit
        Inventory inventory = new Inventory(carryLimit);    //passes carry limit to inventory
        player.addArmor(inventory.getEquippedArmor());
        Scanner input = new Scanner(System.in);
        boolean prompt = true;
        boolean conclusion = true;
        int userSelection;
        while (prompt) {    //while player does not select exit and the battle rages on

            conclusion = false;
            System.out.println("\n" + player.getName());
            System.out.println("Vitality: " + player.getVitality() + "/" + player.getMaxVitality(inventory.getEquippedArmor()));
            System.out.println("Power: " + inventory.getEquippedWeapon().getStrength());
            System.out.println("Carry Capacity: " + inventory.totalWeight() + "/" + carryLimit);
            System.out.println(" \nArmor:  " + inventory.getEquippedArmor() + "\n" + "Weapon: " + inventory.getEquippedWeapon());
            System.out.println("------------------------------");
            System.out.println("1. Battle");
            System.out.println("2. Print Inventory");
            System.out.println("3. Use Healing Item");
            System.out.println("4. Drop item");
            System.out.println("5. Equip weapon");
            System.out.println("6. Equip armor");
            System.out.println("7. Exit");
            System.out.print(": ");

            userSelection = input.nextInt();    //scans users input
            System.out.println();
            switch (userSelection) {
                case 1:
                    Enemy enemy = eventList.enemySpawn(rng);
                    BattleGUI b = new BattleGUI (inventory, player, enemy, rng);
                    while(!conclusion) {
                        conclusion = b.getConclusion();
                    }
                    if(player.getVitality()!=0) {
                        inventory.sort(b.getReward());
                    }
                    break;
                case 2:     //print inventory choice
                    inventory.print();
                    break;
                case 3:     //heal the player
                    player.heal(inventory.useHeal(), inventory.getEquippedArmor());
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
                    System.out.println("Good luck on your journey " + player.getName());
                    prompt = false;
            }
        }
        input.close();
    }
}
