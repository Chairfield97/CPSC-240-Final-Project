import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public void fight(Inventory inventory, Player p, Enemy enemy, Scanner playerInput, Random rng) {
        enemy.sleep();
        BattleGUI gui = new BattleGUI(inventory,p , enemy, rng);
        System.out.println("Starting Weapon: " + inventory.getEquippedWeapon());
//        JPanel panel=new JPanel();
//        panel.setLayout(new BorderLayout());
//        BufferedImage weapImage;
//        try {
//            weapImage = ImageIO.read(new File("pictures/" + inventory.getEquippedWeapon() + ".png"));
//            JLabel label = new JLabel(new ImageIcon(weapImage));
//            panel.add(label);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // main window
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JFrame weapFrame = new JFrame("Weapon");
//        weapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // add the Jpanel to the main window
//        weapFrame.add(panel);
//
//        weapFrame.pack();
//        weapFrame.setVisible(true);
        System.out.println("Starting Armor: " + inventory.getEquippedArmor() + "\n");
//        JPanel armPanel = new JPanel();
//        BufferedImage armImage;
//
//        try {
//            armImage = ImageIO.read(new File("pictures/" + inventory.getEquippedArmor() + ".png"));
//            JLabel armLabel = new JLabel(new ImageIcon(armImage));
//            armPanel.add(armLabel);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        // main window
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JFrame armFrame = new JFrame("Armor");
//        weapFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // add the Jpanel to the main window
//        armFrame.add(armPanel);
//
//        armFrame.pack();
//        armFrame.setVisible(true);
//        enemy.sleep();
        System.out.println("You encountered a " + enemy.getType() + " " + enemy.getVitality() + "\n");

        do {
            p.brawl(enemy, inventory.getEquippedWeapon(), rng, playerInput);
            if (enemy.getVitality() > 0) {
                enemy.brawl(p, rng);
            }
        } while (p.getVitality() > 0 && enemy.getVitality() > 0);

        if (p.getVitality() <= 0) {
            enemy.sleep();
            System.out.println(p.getName() + " was defeated by " + enemy.getType());
        } else {
            enemy.sleep();
            System.out.println(p.getName() + " defeated the " + enemy.getType());
        }
    }
}
