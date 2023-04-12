import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Cyclops implements Enemy {
    private String type="Close minded Cyclops";
    private int vitality=45;
    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(2,3), rng)) {
            System.out.println("Clubbin time");
        } else {
            System.out.println(p.getName() + " dodged the Clubbin time!");
        }
    }


    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(20,22),rng)) {
            System.out.println("punch and kick!!!");
        } else {
            System.out.println(p.getName() + " dodged punch and kick!");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) == 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void defend() {

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getVitality() {
        return vitality;
    }

    @Override
    public JPanel Image() {
        JPanel panel=new JPanel();

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("pictures/Cyclops.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            panel.add(label);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("The Cyclops");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);


        return panel;



    }
}
