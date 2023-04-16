import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
public class Grizzly extends Enemy {
    private String type = "Grandiose Grizzly";
    private int vitality = 50;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,12);
        if (p.damage(damDealt, rng)) {
            return("Paw slice and dice hits -" + damDealt + "\n");
            //System.out.print(RESET);
        } else {
            return(p.getName() + " dodged the slice and dice!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,20);
        if (p.damage(damDealt,rng)) {
            return("Unbearable charge hits!!! -" + damDealt + "\n");
            //System.out.print(RESET);
        } else {
            return(p.getName() + " dodged Unbearable charge!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) == 1) {
            return false;
        } else {
            vitality -= dam;
            return true;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getVitality() {
        return vitality;
    }
    public int getMaxVitality() {
        return maxVitality;
    }

}
