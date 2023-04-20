import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Bandit extends Enemy {
    private String type = "Bankrupt Bandit";
    private int vitality = 35;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(4,9);
        if (p.damage(damDealt, rng)) {
            return("Sword jab hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the sword jab!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,16);
        if (p.damage(damDealt,rng)) {
            return("Shield bash hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged shield bash!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) != 1) {
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
