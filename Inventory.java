import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    //this is a monster pushed every scenario for the inventory
    //in this class

    private ArrayList<Item> items;
    private int maxWeight;
    private Item equippedWeapon;
    private Item equippedArmor;

    //constructor for Inventory
    public Inventory(int maxWeight) {
        this.maxWeight = maxWeight;
        this.equippedWeapon = null;
        this.equippedArmor = null;
        items = new ArrayList<>();
    }

    //tests item weight to maxweight
    //reveals if it is possible to carry
    public boolean add(Item item) {
//        Item item1 = new Item(ItemGenerator.generate());
        if ((totalWeight() + item.getWeight()) < maxWeight) {
            //adds Item without constructor...
//            items.add(ItemGenerator.generate());
            return true;
        } else {
            System.out.println("This will overburden you." +
                    " You should drop something.\n");
            return false;
        }
    }

    //constant run of totalweight
    public int totalWeight() {
        int totalWeight = 0;
        for (Item i : items) {
            totalWeight = totalWeight + i.getWeight();
        }
        return totalWeight;
    }

    //the meat and potatoes of the class
    //prints everything on the screen
    //tried hand at formatting, will have to get better
    public void print() {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int index = 1;

        while (choice != 6) {
            System.out.println("1. Print inventory\n" +
                    "2. Add random item\n" +
                    "3. Drop an item\n" +
                    "4. Equip Weapon\n" +
                    "5. Equip armor\n" +
                    "6. Exit\n");
            choice = in.nextInt();
            if (choice == 1) {
                index = 1;
                if (items.size() > 0) {
                    System.out.printf("%20s %10s %10s %10s",
                            "Item", "Weight", "Value" , "Strength\n");
                } else {
                    System.out.println("There is nothing in your"
                            + " inventory. Try adding something.");
                }
                for (Item i : items) {
                    System.out.printf(index + ": "
                                    + "%15s %10s %10s %10s\n",
                            i.getName(), i.getWeight(),
                            i.getValue(), i.getStrength());
                    index++;
                }
                System.out.println();
            } else if (choice == 2) {
                int itemCount = items.size();
//                System.out.println(ItemGenerator.generate());
//                Item item1 = new Item();
                if (add(ItemGenerator.generate()) == true) {
                    items.add(ItemGenerator.generate());
                    System.out.println("You added the "
                            + items.get(itemCount).getName() +
                            " to your inventory.\n");
                }

            } else if (choice == 3) {
                drop();
            } else if (choice == 4) {
                equipWeapon();
            } else if (choice == 5) {
                equipArmor();
            } else {
                break;
            }
        }
    }

    //dropping an item per user input
    public void drop() {
//        if (items.size() > 0) {
//            System.out.println("Drop an item");
//        } else {
//            return;
//        }
        System.out.println("Drop an item");
        System.out.printf("%20s %10s %10s %10s",
                "Item", "Weight", "Value" , "Strength\n");
        int count = 1;
        for(Item i : items) {
            System.out.printf(count + ": "
                            + "%15s %10s %10s %10s\n",
                    i.getName(), i.getWeight(),
                    i.getValue(), i.getStrength());
            count++;
        }
        System.out.println(count + ". Cancel");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        if (index < count) {
            System.out.println("You dropped the "
                    + items.get(index-1).getName() + ".\n");
            items.remove(index - 1);

        }
    }

    //equipping weapons from weapon selection
    public void equipWeapon() {

        ArrayList<Item> weapons = new ArrayList<>();
//        if (weapons.size() > 0) {
//            System.out.println("Equip a weapon");
//        } else {
//            return;
//        }
        System.out.println("Equip a weapon");
        System.out.printf("%20s %10s %10s %10s",
                "Item", "Weight", "Value" , "Strength\n");
        Scanner in = new Scanner(System.in);
        int count = 1;
        for(Item w : items) {
            w.getType();
            if (w.getType() == ItemType.Weapon) {
                System.out.printf(count + ": "
                                + "%15s %10s %10s %10s\n",
                        w.getName(), w.getWeight(),
                        w.getValue(), w.getStrength());
                count++;
                weapons.add(w);
            }

        }
        System.out.println((count) + ". Cancel");
        int selection = in.nextInt();
        if (weapons.size() == 0) {
            System.out.println();
            return;
        }
        if (selection < weapons.size()+1) {
            this.equippedWeapon = weapons.get(selection-1);
            System.out.println("You equipped the "
                    + equippedWeapon.getName() + ".\n");
        }

    }

    //equipping armor through armor selection
    public void equipArmor() {
        ArrayList<Item> armors = new ArrayList<>();
//        if (armors.size() > 0) {
//            System.out.println("Equip an armor");
//        } else {
//            return;
//        }
        System.out.println("Equip armor");
        System.out.printf("%20s %10s %10s %10s",
                "Item", "Weight", "Value" , "Strength\n");
        Scanner in = new Scanner(System.in);
        int count = 1;
        for(Item a : items) {
            a.getType();
            if (a.getType() == ItemType.Armor) {
                System.out.printf(count + ": "
                                + "%15s %10s %10s %10s\n",
                        a.getName(), a.getWeight(),
                        a.getValue(), a.getStrength());
                count++;
                armors.add(a);
            }

        }
        System.out.println((count) + ". Cancel");
        int selection = in.nextInt();
        if (armors.size() == 0) {
            System.out.println();
            return;
        }
        if (selection < armors.size()+1) {
            this.equippedArmor = armors.get(selection-1);
            System.out.println("You equipped the "
                    + equippedArmor.getName() + ".\n");
        }
    }
}
