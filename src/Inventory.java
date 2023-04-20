import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private int carryLimit;
    private Item equippedWeapon = null;
    private Item equippedArmor = null;
    Scanner scnr = new Scanner(System.in);

    public Inventory (int carryLimit) {

        this.carryLimit = carryLimit;      //initializes carry limit
        if ( carryLimit >= 90 ) {       //if carry limit is higher than usual
            System.out.println("You are feeling strong today!");
        }

        inventory.add(new Item(ItemType.Healing, "Small Health Potion", 1, 5, 15));
        inventory.add(new Item(ItemType.Healing, "Medium Health Potion", 1, 5, 30));
        inventory.add(new Item(ItemType.Healing, "Large Health Potion", 1, 5, 50));

        Item startingItem = ItemGenerator.generate();

        while (equippedWeapon == null || equippedArmor == null) {   // gives player starting weapon and armor
            if (startingItem.getItemType() == (ItemType.Weapon) && equippedWeapon == null) {
                inventory.add(startingItem);
                equippedWeapon = startingItem;
            } else if (startingItem.getItemType() == (ItemType.Armor) && equippedArmor == null) {
                inventory.add(startingItem);
                equippedArmor = startingItem;
            }
            startingItem = ItemGenerator.generate();
        }
    }
    public boolean add(Item item) {     // can add item to inventory and returns if it did or not

        if ((item.getWeight() + totalWeight()) <= carryLimit) { //if player can carry
            inventory.add(item);
            System.out.println("<The " + item + " was added to your inventory>");
            return true;
        } else {    // if player cannot carry
            System.out.println("<Picking up the " + item + " will exceed your carry limit of " + carryLimit + ">");
            return false;
        }
    }
    public int totalWeight() {      //calculates and returns total weight of player inventory
        int newWeight = 0;
        for (Item i : inventory) {
            newWeight += i.getWeight();
        }
        return newWeight;
    }
    public int getCarryLimit() {
        return this.carryLimit;
    }
    public void print() {   //prints out all items in player inventory

        System.out.printf("%-30s %10s %9s %13s","Item","Weight","Value","Strength\n");
        for (Item i : inventory) {
            System.out.printf("%-30s%11s%10s%13s\n",i,i.getWeight(),i.getValue(),i.getStrength());
        }
    }
    public Item drop() {    //removes selected item from player inventory
        System.out.println("\nDrop an item ");
        System.out.printf("   %-28s %10s %9s %13s","Item","Weight","Value","Strength\n");
        for (Item i : inventory) {      //prints all items
            int indexNum = inventory.indexOf(i) + 1;
            if (indexNum > 9) {     //print format
                System.out.printf("%d. %-28s%10s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());

            } else {    //print format
                System.out.printf("%d. %-28s%11s%10s%13s\n", indexNum, i, i.getWeight(), i.getValue(), i.getStrength());
            }
        }
        System.out.println(inventory.size() + 1 + ". Cancel");
        System.out.print(": ");
        int choice = scnr.nextInt() - 1;
        scnr.nextLine();
        if (inventory.size() == 0) {    //if player inventory is empty
            System.out.println("No items in inventory.");
            return null;
        }
        else if ( 0 <= choice && choice < inventory.size()) {   //if player makes a valid selection
            System.out.println("You dropped the " + inventory.get(choice));
            return inventory.remove(choice);
        } else {                                                //everything else
            System.out.println("Drop cancelled");
            return null;
        }
    }
    public void equipWeapon() {     //equips weapon of players choice from inventory

        ArrayList<Item> weaponSelection = new ArrayList<>();

        System.out.println("\nEquip a weapon");
        System.out.printf("   %-28s %9s %9s %13s","Item","Weight","Value","Strength\n");
        for (Item i : inventory) {  //prints out all weapons in player inventory
            if (String.valueOf(i.getItemType()).equals("Weapon")) {
                weaponSelection.add(i);
                System.out.printf("%d. %-27s%11s%10s%13s\n",weaponSelection.indexOf(i) + 1,i,i.getWeight(),i.getValue(),i.getStrength());
                //int inventoryIndex = inventory.indexOf(i);
            }
        }
        System.out.println(weaponSelection.size() + 1 + ". Cancel");
        System.out.print(": ");
        int weaponChoice = scnr.nextInt();
        if (weaponSelection.size() == 0) {      //if no weapons in inventory
            System.out.println("You have no weapons in your inventory.");
        } else if (!(weaponChoice == weaponSelection.size() + 1)) {       //if player makes a valid selection
            equippedWeapon = weaponSelection.get(weaponChoice - 1);
            System.out.println("You equipped the " + equippedWeapon);
        } else {        //everything else

            System.out.println("Equip weapon cancelled.");
        }
    }
    public void equipArmor() {      //equips armor of players choice from inventory

        ArrayList<Item> armorSelection = new ArrayList<>();

        System.out.println("\nEquip armor");
        System.out.printf("   %-28s %9s %9s %13s","Item","Weight","Value","Strength\n");
        for (Item i : inventory) {      //prints out all armor in players inventory
            if (String.valueOf(i.getItemType()).equals("Armor")) {
                armorSelection.add(i);
                System.out.printf("%d. %-27s%11s%10s%13s\n",armorSelection.indexOf(i)+1,i,i.getWeight(),i.getValue(),i.getStrength());
                //int inventoryIndex = inventory.indexOf(i);
            }
        }
        System.out.println(armorSelection.size() + 1 + ". Cancel");
        System.out.print(": ");
        int armorChoice = scnr.nextInt();
        if (armorSelection.size() == 0) {       //if no armor in player inventory
            System.out.println("You have no armor in your inventory.");
        } else if (!(armorChoice == armorSelection.size() + 1)) {     //if player makes a valid selection
            equippedArmor = armorSelection.get(armorChoice - 1);
            System.out.println("You equipped the " + equippedArmor);
        } else {    //everything else
            System.out.println("Equip armor cancelled.");
        }
    }

    public int useHeal() {
        ArrayList<Item> healSelection = new ArrayList<>();

        System.out.println("\nSelect a healing item");
        System.out.printf("   %-28s %9s %9s %13s","Item","Weight","Value","Strength\n");
        for (Item i : inventory) {  //prints out all healing items in player inventory
            if (String.valueOf(i.getItemType()).equals("Healing")) {
                healSelection.add(i);
                System.out.printf("%d. %-27s%11s%10s%13s\n",healSelection.indexOf(i) + 1,i,i.getWeight(),i.getValue(),i.getStrength());
                //int inventoryIndex = inventory.indexOf(i);
            }
        }
        System.out.println(healSelection.size() + 1 + ". Cancel");
        System.out.print(": ");
        int healChoice = scnr.nextInt();
        if (healSelection.size() == 0) {       //if no armor in player inventory
            System.out.println("\nYou have no healing items in your inventory.");
            return 0;
        } else if (!(healChoice == healSelection.size() + 1)) {     //if player makes a valid selection
            Item healItem = healSelection.get(healChoice - 1);
            System.out.println("\nYou used the " + healItem.getName());
            inventory.remove(healItem);
            return healItem.getStrength();
        } else {                                //everything else
            System.out.println("\nUse healing item cancelled.");
            return 0;
        }
    }
    public void sort (Item item) {
        String choice;
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("(Y)es to add " + item.getName() + " Weight: " + item.getWeight() + " Value: " + item.getValue() + " to your inventory or (N)o to discard");
            choice = input.nextLine();

        } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));

        if (choice.equalsIgnoreCase("Y"))
            while (!add(item)) {
                drop();
        } else if (choice.equalsIgnoreCase("N")) {
                System.out.println("You discarded the " + item.getName());
        }
    }
    public Item getEquippedWeapon() {
        return equippedWeapon;
    }
    public Item getEquippedArmor() {
        return equippedArmor;
    }
}