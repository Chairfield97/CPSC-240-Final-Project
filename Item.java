import java.util.Scanner;

public class Item {
    //Item calls Items and assigns the attributes
    //getAttributes throughout Item

    //class attributes
    private ItemType type;
    private String name;
    private int weight;
    private int value;
    private int strength;

    //Item constructor to initiate a default Item
    public Item() {
        type = ItemType.Weapon;
        name = "Nothing";
        weight = 30;
        value = 0;
        strength = 0;
    }

    //constructor to initialize all the variables
    public Item(ItemType type, String name, int weight, int value, int strength) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.strength = strength;
    }
   //load and Item
    //get the weight of Item
    public int getWeight() {
        return weight;
    }

    //get the value of Item
    public int getValue() {
        return value;
    }

    //get the name of Item
    public String getName() {
        return name;
    }

    //get the type of the Item
    public ItemType getType() {
        return type;
    }

    public int getStrength() {
        return strength;
    }

    //print in a nice format.. will have to format it a little better
    public String toString() {
        return type+" "+name+" "+weight+" "+value+" "+strength;
    }

}
