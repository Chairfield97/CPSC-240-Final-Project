import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//running project
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    // erases the file from the results.txt, comes up with the main menu, and uses switch to execute this menu
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
        Merchant merchant = new Merchant();
        player.addArmor(inventory.getEquippedArmor());
        Scanner input = new Scanner(System.in);
        boolean prompt = true;
        boolean conclusion = true;
        int userSelection;
        while (prompt) {    //while player does not select exit and the battle rages on

            conclusion = false;
            System.out.println("\n" + player.getName());
            System.out.println(ANSI_CYAN + "Power: " + inventory.getEquippedWeapon().getStrength());
            System.out.println(ANSI_YELLOW + "Credits: " + player.getCredits());
            System.out.println(ANSI_RED + "Vitality: " + player.getVitality() + "/" + player.getMaxVitality(inventory.getEquippedArmor()));
            System.out.println(ANSI_PURPLE + "Carry Capacity: " + inventory.totalWeight() + "/" + carryLimit);
            System.out.println(ANSI_BLUE + " \nArmor: " + inventory.getEquippedArmor() + "\n" + "Weapon: " + inventory.getEquippedWeapon() + ANSI_RESET);
            System.out.println("------------------------------");
            System.out.println("1. Battle");
            System.out.println("2. Print Inventory");
            System.out.println("3. Use Healing Item");
            System.out.println("4. Visit Merchant");
            System.out.println("5. Drop item");
            System.out.println("6. Equip weapon");
            System.out.println("7. Equip armor");
            System.out.println("8. Exit");
            System.out.print(": ");

            userSelection = input.nextInt();    //scans users input
            System.out.println();
            switch (userSelection) {
                case 1:
                    Enemy enemy = eventList.enemySpawn(player, rng);
                    BattleGUI b = new BattleGUI (inventory, player, enemy, rng);
                    while(!conclusion) {
                        conclusion = b.getConclusion();
                    }
                    if(player.getVitality() > 0) {
                        inventory.sort(b.getReward());
                        player.bonusCredits(rng);
                    } else {
                        prompt = false;
                    }
                    break;
                case 2:     //print inventory choice
                    inventory.print();
                    break;
                case 3:     //heal the player
                    System.out.println(ANSI_RED + "Vitality: " + player.getVitality() + "/" + player.getMaxVitality(inventory.getEquippedArmor()) + ANSI_RESET);
                    player.heal(inventory.useHeal(), inventory.getEquippedArmor());
                    break;
                case 4:
                    merchant.greeting(inventory, player, rng);
                    break;
                case 5:     //drop item choice
                    inventory.drop();
                    break;
                case 6:     //equip weapon choice
                    inventory.equipWeapon();
                    break;
                case 7:     //equip armor choice
                    inventory.equipArmor();
                    break;
                case 8:     //exit out
                    System.out.println("Good luck on your journey " + player.getName());
                    prompt = false;
                    break;
            }
        }
        input.close();
    }
}
