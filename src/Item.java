// Creates Item
public class Item {
    private ItemType itemType;
    private String name;
    private int weight;
    private int value;
    private int strength;

    public Item (ItemType itemType, String name, int weight, int value, int strength) { //constructs individual items
        this.itemType = itemType;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.strength = strength;
    }
    // gets name of Item
    public String getName() {
        return name;
    }
    // gets Itemtype of the Item
    public ItemType getItemType() {     //returns item type
        return itemType;
    }
    //gets weight of the Item
    public int getWeight() {        //returns item weight
        return weight;
    }
    //gets value of the item

    public int getValue() {     //returns item value
        return value;
    }
    //gets strength of the Item

    public int getStrength() {      //returns item strength
        return strength;
    }
    @Override
    public String toString() {      //returns string value of item properties

        String itemName = String.valueOf(name);
        String itemWeight = String.valueOf(weight);
        String itemValue = String.valueOf(value);
        String itemStrength = String.valueOf(strength);
        return itemName;
    }
}
