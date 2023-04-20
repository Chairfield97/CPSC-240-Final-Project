import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Mercenary extends Enemy {
    private String type = "Marksman Mercenary";
    private int vitality = 30;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(7,13);
        if (p.damage(damDealt, rng)) {
            return("Arrow shot hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the arrow shot!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,19);
        if (p.damage(damDealt,rng)) {
            return("Crude explosive hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the crude explosive!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) != 1) {
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
