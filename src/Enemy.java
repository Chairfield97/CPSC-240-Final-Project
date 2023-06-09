import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
// Added the abstract as a Enemy
public abstract class Enemy {
    ArrayList <Enemy> enemy = new ArrayList<>();
    String RED = "\u001B[31m";
    String RESET = "\033[0m";
    protected String type;
    protected int vitality;
    protected int maxVitality;
    abstract public String attack(Player p, Random rng);
    abstract public String specAttack(Player p, Random rng);
    abstract public boolean damage(int dam, Random rng);
    public void Generate() {
        File f = new File("pictures");
        Random r = new Random();
        for(int b = 0; b < enemy.size(); b++) {
            int p = r.nextInt(enemy.size());
            Enemy temp = enemy.remove(p);
            p = r.nextInt(enemy.size());
            enemy.add(p, temp);
        }
    }
    //Player randomized attacks when clicked
    public String brawl(Player p, Random rng) {
        //System.out.println(getType() + ": " + getVitality());
        if (getVitality() > getMaxVitality()/2) {
            if (rng.nextInt(0,7) == 1) {
                return specAttack(p, rng);
            } else {
                return attack(p, rng);
            }
        } else {
            if (rng.nextInt(0,3) == 1) {
                return specAttack(p, rng);
            } else {
                return attack(p, rng);
            }
        }
    }
    //getting type
    public String getType() {
        return type;
    }
    // getting health
    public int getVitality() {
        return vitality;
    }
    //getting Max health
    public int getMaxVitality() {
        return maxVitality;
    }
    //Was using this to make it wait longer.
    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignore
        }
    }
//    public JPanel Image() {
//
//            JPanel panel=new JPanel();
//
//            BufferedImage image = null;
//            try {
//                image = ImageIO.read(new File("pictures/" + getClass().getSimpleName() + ".png"));
//                JLabel label = new JLabel(new ImageIcon(image));
//                panel.add(label);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            // main window
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            JFrame frame = new JFrame("The " + getClass().getSimpleName());
//            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//            // add the Jpanel to the main window
//            frame.add(panel);
//
//            frame.pack();
//            frame.setVisible(true);
//
//
//            return panel;
//
//    }
}
