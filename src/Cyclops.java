import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Cyclops extends Enemy {
    private String type = "Close-Minded Cyclops";
    private int vitality=45;
    private final int maxVitality = getVitality();
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(8,14);
        if (p.damage(damDealt, rng)) {
            return("Clubbin time hit! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the Clubbin time!\n");
        }
    }


    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(15,25);
        if (p.damage(damDealt, rng)) {
            return("punch and kick hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged punch and kick!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,5) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
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
