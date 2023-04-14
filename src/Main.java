import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance(playerInput);
        ItemGenerator.itemSelection("Items.txt");
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);
        Inventory inventory = new Inventory(carryLimit);
        p.addArmor(inventory.getEquippedArmor());
        System.out.println(p.getName() + ": " + p.getVitality());
        System.out.println("Starting Weapon: " + inventory.getEquippedWeapon());
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        BufferedImage image = null;
        try {
            //weapImage = ImageIO.read(new File("pictures/" + inventory.getEquippedWeapon() + ".png"));
            image = ImageIO.read(new File("pictures/" + "Crystal Halberd" + ".png"));

            JLabel label = new JLabel(new ImageIcon(image));
            panel.add(label);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("The " + Main.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
        System.out.println("Starting Armor: " + inventory.getEquippedArmor() + "\n");
        JPanel panel1 = new JPanel();
        BufferedImage image1 = null;

        try {
            //armImage = ImageIO.read(new File("pictures/" + inventory.getEquippedArmor() + ".png"));
            image1 = ImageIO.read(new File("pictures/" + "Obsidian Infused Armor" + ".png"));
            JLabel label1 = new JLabel(new ImageIcon(image1));
            panel1.add(label1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame1 = new JFrame("The " + Main.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame1.add(panel1);

        frame1.pack();
        frame1.setVisible(true);
        //for ( int i = 0; i < 5; i++) {
            //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        Grizzly g = new Grizzly();
        g.Image();


        do {
            p.brawl(g, inventory.getEquippedWeapon(), rng, playerInput);
            if (g.getVitality() > 0) {
                g.brawl(p, rng);
            }
        } while (p.getVitality() > 0 && g.getVitality() > 0);

        if (p.getVitality() <= 0) {
            System.out.println(p.getName() + " was defeated by " + g.getType());
        } else {
            System.out.println(p.getName() + " defeated the " + g.getType());
        }
    }
}
