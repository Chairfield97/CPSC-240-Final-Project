import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.*;
// to be able to buy and sell items
public class Merchant {
    private ArrayList<Item> shopItems = new ArrayList<>();
    AudioInputStream audioInputStream;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private boolean leave;
    //get up to 10 random Items and Herbs and open to a menu that you can select to buy
    public void greeting(Inventory inventory, Player player, Random rng) {
        int numItems = rng.nextInt(1, 10);
        for (int i = 0; i <= numItems; i++) {
            shopItems.add(ItemGenerator.generate());
        }
        shopItems.add(new Item(ItemType.Healing, "Green Herb", 1, 3,10));
        shopItems.add(new Item(ItemType.Healing, "Green+Red Herb Mix", 1, 8,25));
        shopItems.add(new Item(ItemType.Healing, "Green+Red+Yellow Herb Mix", 1, 15,50));

        //various greetings possible
        int greeting = rng.nextInt(1,5);
        switch(greeting) {
            case 1:
                System.out.println(ANSI_GREEN + "\"Got a selection of good things on sale, stranger!\"\n" + ANSI_RESET);
                audio("Selection");
                sleep(3000);
                break;
            case 2:
                System.out.println(ANSI_GREEN + "\"Got somethin' that might interest ya, hehehehehehehe.\"\n" + ANSI_RESET);
                audio("gotsomething");
            sleep(3000);
                break;
            case 3:
                System.out.println(ANSI_GREEN + "\"Got some rare things on sale, stranger!\"\n" + ANSI_RESET);
                audio("Rare things");
                sleep(2500);
                break;
            case 4:
                System.out.println(ANSI_GREEN + "\"Welcome!\"\n" + ANSI_RESET);
                audio("Welcome");
                sleep(1000);
                break;
        }
        leave = false;
        String choice ="";
        while (!leave) {
            // Main merchant screen
            System.out.print("(B) to buy - (S) to sell - (Enter) to exit\n:");
            Scanner select = new Scanner(System.in);
            choice = select.nextLine();
            // while player chooses to buy
            if (choice.equalsIgnoreCase("B")) {
                boolean buying = true;
                do {
                    System.out.println(ANSI_YELLOW + "\nCredits: " + player.getCredits() + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "\n\"What are ya buyin'?\"" + ANSI_RESET);
                    audio("Buying");
                    System.out.printf("   %-28s %10s %9s %13s", "Item", "Weight", "Value", "Strength\n");
                    for (Item i : shopItems) {
                        int indexNum = shopItems.indexOf(i) + 1;
                        if (indexNum > 9) {     //print format
                            System.out.printf("%d. %-28s%10s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());

                        } else {    //print format
                            System.out.printf("%d. %-28s%11s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());
                        }
                    }
                    System.out.println(shopItems.size() + 1 + ". Cancel");
                    System.out.print(": ");
                    int selection = select.nextInt() - 1;
                    if (shopItems.size() == 0) {
                        System.out.println(ANSI_GREEN + "\"That is all, stranger!\"\n" + ANSI_RESET);
                    } else if (0 <= selection && selection < shopItems.size()) {   //if player selects an item
                        Item item = shopItems.get(selection);
                        if (player.getCredits() >= item.getValue()) {   //if player has enough credits
                            player.removeCredits(item.getValue());
                            System.out.println(ANSI_GREEN + "\n\"Hehehehe, thank you.\" " + ANSI_RED + "-" + item.getValue() + " credits" + ANSI_RESET);
                            audio("cashier-quotka-chingquot-sound-effect-129698");
                            audio("Thank you");
                            System.out.println("You purchased the " + shopItems.remove(selection));
                            inventory.add(item);
                            sleep(2000);
                        } else {            // when player has insufficient funds
                            System.out.println(ANSI_RED + "\n\"Not enough cash, stranger!\"\n" + ANSI_RESET);
                            audio("Not enough");
                            sleep(2500);
                        }
                    } else if (selection == shopItems.size()) {     // if choice is to cancel
                        System.out.println(ANSI_GREEN + "\n\"Maybe next time stranger\"\n" + ANSI_RESET);
                        buying = false;
                    } else {                // if player does not select a valid option
                        System.out.println(ANSI_RED + "\n\"Stop wasting my time!!!\"\n" + ANSI_RESET);
                        audio("disgust");
                        sleep(2000);
                        buying = false;
                    }
                } while(buying);
            //while player chooses to sell
            } else if (choice.equalsIgnoreCase("S")) {
                boolean selling = true;
                do {
                    System.out.println(ANSI_YELLOW + "\nCredits: " + player.getCredits() + "\n" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "\"What are ya sellin'?\"" + ANSI_RESET);
                    audio("Selling");
                    Item sale = inventory.drop();
                    if (sale == null) {             //if player chooses not to sell
                        System.out.println(ANSI_GREEN + "\n\"Maybe next time stranger\"\n" + ANSI_RESET);
                        selling = false;
                    } else if (player.addCredits(sale.getValue()) > 0) {    // if item has some value
                        System.out.println(ANSI_GREEN + "\n\"Hehehehe, thank you.\" " + ANSI_YELLOW + "+" + sale.getValue() + " credits" + ANSI_RESET + "\n");
                        audio("cashier-quotka-chingquot-sound-effect-129698");
                        audio("Thank you");
                        shopItems.add(sale);
                        sleep(2000);
                    } else {        //if item had 0 value
                        System.out.println(ANSI_RED + "\nWhy do I want this worthless " + sale.getName() + "?\n" + ANSI_RESET);
                        audio("disgust");
                        sleep(3300);
                    }
                } while(selling);
            } else {
                leave = true;
            }
        }
        shelve();
        System.out.println(ANSI_GREEN + "\n\"Come back any time.\"" + ANSI_RESET);
        audio("comeback");
        sleep(1000);
    }
    // Restore Items back to items list and clears merchant's wares
    public void shelve() {
        for (Item i: shopItems) {
            ItemGenerator.restore(i);
            //shopItems.remove(i);
        }
        shopItems.clear();
    }
    // plays the audio file passed into it
    public void audio(String fileName) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("audio/" + fileName + ".wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException es) {
            throw new RuntimeException(es);
        } catch (IOException es) {
            throw new RuntimeException(es);
        } catch (LineUnavailableException es) {
            throw new RuntimeException(es);
        }
    }
    //halts progress for dialogue
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
