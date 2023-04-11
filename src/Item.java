package src;

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

    public String getName() {
        return name;
    }
    public ItemType getItemType() {     //returns item type
        return itemType;
    }
    public int getWeight() {        //returns item weight
        return weight;
    }

    public int getValue() {     //returns item value
        return value;
    }

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
