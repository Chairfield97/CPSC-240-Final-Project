import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public interface Enemy {
    ArrayList <Enemy>enemy=new ArrayList<>();
    String RED = "\u001B[31m";
    String RESET = "\033[0m";
    String ANSI_WHITE = "\u001B[37m";
    public void attack(Player p, Random rng);
    public void specAttack(Player p, Random rng);
    public boolean damage(int dam, Random rng);
    public default void brawl(){
        File f=new File("pictures/");
        Random r=new Random();
        for(int b=0;b< enemy.size();b++) {
            int p = r.nextInt( enemy.size());
            Enemy temp = enemy.remove(p);
            p= r.nextInt(enemy.size());
            enemy.add(p, temp);
        }
    }
    public String getType();
    public int getVitality();
    public default JPanel Image() {

            JPanel panel=new JPanel();

            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("pictures/" + getClass().getSimpleName() + ".png"));
                JLabel label = new JLabel(new ImageIcon(image));
                panel.add(label);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // main window
            JFrame.setDefaultLookAndFeelDecorated(true);
            JFrame frame = new JFrame("The " + getClass().getSimpleName());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // add the Jpanel to the main window
            frame.add(panel);

            frame.pack();
            frame.setVisible(true);


            return panel;

    }
}
