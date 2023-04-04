import java.util.Random;
     public class ItemGenerator {
         //random item generator which produces items at the call of the
         //user. Probably could've worked with heavier items to hasten
         //the overburden. Tried using Case... still not that familiar
         //with it.
         public static Item generate() {

             Random rng = new Random();
             int ranNum = rng.nextInt(10);
             if (ranNum == 0) {
                 ItemType type = ItemType.Weapon;
                 return new Item(type, "Bazooka",
                         40, 5, 20);
             } else if (ranNum == 1) {
                 ItemType type = ItemType.Armor;
                 return new Item(type, "Steel gauntlets",
                         15, 5, 20);
             } else if (ranNum == 2) {
                 ItemType type = ItemType.Other;
                 return new Item(type, "Spork",
                         1, 1, 1);
             } else if (ranNum == 3) {
                 ItemType type = ItemType.Weapon;
                 return new Item(type, "Steel sword",
                         20, 10, 10);
             } else if (ranNum == 4) {
                 ItemType type = ItemType.Armor;
                 return new Item(type, "Steel helm",
                         9, 4, 4);
             } else if (ranNum == 5) {
                 ItemType type = ItemType.Other;
                 return new Item(type, "Cards",
                         1, 1, 1);
             } else if (ranNum == 6) {
                 ItemType type = ItemType.Weapon;
                 return new Item(type, "Nun-chucks",
                         3, 3, 3);
             } else if (ranNum == 7) {
                 ItemType type = ItemType.Armor;
                 return new Item(type, "Bikini",
                         2, 2, 2);
             } else if (ranNum == 8) {
                 ItemType type = ItemType.Other;
                 return new Item(type, "Lollipop",
                         1, 1, 1);
             } else {
                 ItemType type = ItemType.Weapon;
                 return new Item(type, "Keyboard",
                         6, 6, 7);
             }
         }
     }