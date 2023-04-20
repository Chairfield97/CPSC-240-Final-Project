import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ItemGenerator {

    private static ArrayList<Item> items = new ArrayList<>();

    public static void itemSelection(String fileName) {     //imports items from text file
        FileInputStream fis;
        try {       //if file is found
            fis = new FileInputStream(fileName);
            Scanner fileScan = new Scanner(fis);
            while (fileScan.hasNext()) {
                ItemType type = ItemType.valueOf(fileScan.next());
                fileScan.nextLine();
                String name = fileScan.nextLine();
                int weight = fileScan.nextInt();
                fileScan.nextLine();
                int value = fileScan.nextInt();
                fileScan.nextLine();
                int strength = fileScan.nextInt();
                items.add(new Item(type, name, weight, value, strength));
            }
            fileScan.close();
        } catch (FileNotFoundException e) {     //if text file is not found
            System.out.print(e.getMessage());
            System.exit(0);
        }
    }
    //adds Item
    public static void restore(Item item) {
        items.add(item);
    }
    public static Item generate() {     //returns an item from the available items
        Random rng = new Random();
        int index = 0;
        try {
            //System.out.println(items.size());
            index = rng.nextInt(0, items.size());
        } catch (IllegalArgumentException e) {
            System.out.println("Possible items depleted.");
            System.exit(0);
        }
        //Item item = items.get(index);
        //items.remove(index);
        return items.remove(index);
    }
}