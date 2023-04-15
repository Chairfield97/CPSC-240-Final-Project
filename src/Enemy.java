import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public abstract class Enemy {
    ArrayList <Enemy> enemy = new ArrayList<>();
    String RED = "\u001B[31m";
    String RESET = "\033[0m";
    protected String type;
    protected int vitality;
    protected int maxVitality;
    abstract public void attack(Player p, Random rng);
    abstract public void specAttack(Player p, Random rng);
    abstract public boolean damage(int dam, Random rng);
    public void Generate(){
        File f = new File("pictures");
        Random r = new Random();
        for(int b = 0; b < enemy.size(); b++) {
            int p = r.nextInt(enemy.size());
            Enemy temp = enemy.remove(p);
            p = r.nextInt(enemy.size());
            enemy.add(p, temp);
        }
    }
    public void brawl(Player p, Random rng) {
        sleep();
        System.out.println(getType() + ": " + getVitality());
        if (getVitality() > getMaxVitality()/2) {
            if (rng.nextInt(0,7) == 1) {
                specAttack(p, rng);
            } else {
                attack(p, rng);
            }
        } else {
            if (rng.nextInt(0,3) == 1) {
                specAttack(p, rng);
            } else {
                attack(p, rng);
            }
        }
    }
    public String getType() {
        return type;
    }
    public int getVitality() {
        return vitality;
    }
    public int getMaxVitality() {
        return maxVitality;
    }
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
