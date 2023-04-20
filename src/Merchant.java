import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Merchant {
    private ArrayList<Item> shopItems = new ArrayList<>();
    Scanner select;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private boolean leave;

    public void greeting(Inventory inventory, Player player, Random rng) {
        int numItems = rng.nextInt(1, 10);
        for (int i = 0; i <= numItems; i++) {
            shopItems.add(ItemGenerator.generate());
        }
        shopItems.add(new Item(ItemType.Healing, "Green Herb", 1, 3,10));
        shopItems.add(new Item(ItemType.Healing, "Green+Red Herb Mix", 1, 8,25));
        shopItems.add(new Item(ItemType.Healing, "Green+Red+Yellow Herb Mix", 1, 15,50));

        int greeting = rng.nextInt(1,5);
        switch(greeting) {
            case 1:
                System.out.println(ANSI_GREEN + "\"Got a selection of good things on sale, stranger!\"\n" + ANSI_RESET);
                break;
            case 2:
                System.out.println(ANSI_GREEN + "\"Got somethin' that might interest ya, hehehehehehehe.\"\n" + ANSI_RESET);
                break;
            case 3:
                System.out.println(ANSI_GREEN + "\"Got some rare things on sale, stranger!\"\n" + ANSI_RESET);
                break;
            case 4:
                System.out.println(ANSI_GREEN + "\"Welcome!\"\n" + ANSI_RESET);
                break;
        }
        leave = false;
        String choice ="";
        while (!leave) {
            System.out.print("(B) to buy - (S) to sell - (Enter) to exit\n:");
            select = new Scanner(System.in);
            choice = select.nextLine();
            if (choice.equalsIgnoreCase("B")) {
                boolean buying = true;
                do {
                    System.out.println(ANSI_YELLOW + "Credits: " + player.getCredits() + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "\"What are ya buyin'?\"\n" + ANSI_RESET);
                    System.out.printf("   %-28s %10s %9s %13s", "Item", "Weight", "Value", "Strength\n");
                    for (Item i : shopItems) {
                        int indexNum = shopItems.indexOf(i) + 1;
                        if (indexNum > 9) {     //print format
                            System.out.printf("%d. %-28s%10s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());

                        } else {    //print format
                            System.out.printf("%d. %-28s%11s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());
                        }
                    }
                    System.out.println(shopItems.size() + 1 + ". Cancel\n");
                    System.out.print(": ");
                    int selection = select.nextInt() - 1;
                    if (shopItems.size() == 0) {
                        System.out.println(ANSI_GREEN + "\"That is all, stranger!\"\n" + ANSI_RESET);
                    } else if (0 <= selection && selection < shopItems.size()) {   //if player makes a valid selection
                        Item item = shopItems.get(selection);
                        if (player.getCredits() >= item.getValue()) {
                            player.removeCredits(item.getValue());
                            System.out.println(ANSI_GREEN + "\"Hehehehe, thank you.\"\n" + ANSI_RESET);
                            System.out.println("You purchased the " + shopItems.remove(selection) + "\n");
                            inventory.add(item);
                        } else {
                            System.out.println(ANSI_RED + "\"Not enough cash, stranger!\"\n" + ANSI_RESET);
                        }
                    } else if (selection == shopItems.size()) {
                        System.out.println(ANSI_GREEN + "\"Maybe next time stranger\"\n" + ANSI_RESET);
                        buying = false;
                    } else {
                        System.out.println(ANSI_RED + "\"Stop wasting my time!!!\"\n" + ANSI_RESET);
                        buying = false;
                    }
                } while(buying);
            } else if (choice.equalsIgnoreCase("S")) {
                boolean selling = true;
                do {
                    System.out.println(ANSI_YELLOW + "Credits: " + player.getCredits() + "\n" + ANSI_RESET);
                    System.out.println(ANSI_GREEN + "\"What are ya sellin'?\"" + ANSI_RESET);
                    Item sale = inventory.drop();
                    if (sale == null) {
                        System.out.println(ANSI_GREEN + "\"Maybe next time stranger\"\n" + ANSI_RESET);
                        selling = false;
                    } else if (player.addCredits(sale.getValue()) > player.getCredits()) {
                        System.out.println(ANSI_GREEN + "\"Hehehehe, thank you.\"\n" + ANSI_RESET);
                        shopItems.add(sale);
                    } else {
                        System.out.println(ANSI_RED + "Why do I want this worthless " + sale.getName() + ANSI_RESET);
                    }
                } while(selling);
            } else {
                leave = true;
            }
        }
        shelve();
        System.out.println(ANSI_GREEN + "\"Come back any time.\"\n" + ANSI_RESET);
    }
    public void shelve() {
        for (Item i: shopItems) {
            ItemGenerator.restore(i);
            //shopItems.remove(i);
        }
        shopItems.clear();
    }
}
