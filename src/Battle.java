import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public void fight(Inventory inventory, Player p, Enemy enemy, Random rng) {
        enemy.sleep();

        BattleGUI gui = new BattleGUI(inventory,p , enemy, rng);


//
//        do {
//            p.brawl(enemy, inventory.getEquippedWeapon(), rng, playerInput);
//            if (enemy.getVitality() > 0) {
//                enemy.brawl(p, rng);
//            }
//        } while (p.getVitality() > 0 && enemy.getVitality() > 0);
//
//        if (p.getVitality() <= 0) {
//            enemy.sleep();
//            System.out.println(p.getName() + " was defeated by " + enemy.getType());
//        } else {
//            enemy.sleep();
//            System.out.println(p.getName() + " defeated the " + enemy.getType());
//        }
    }
}
