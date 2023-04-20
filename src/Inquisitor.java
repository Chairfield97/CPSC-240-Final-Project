import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Inquisitor extends Enemy {
    private String type = "Impervious Inquisitor";
    private int vitality = 50;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,17);
        if (p.damage(damDealt, rng)) {
            return("Brute bludgeoning hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the brute bludgeoning!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(17,30);
        if (p.damage(damDealt,rng)) {
            return("Dark magic spell hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the dark magic spell!\n");
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
