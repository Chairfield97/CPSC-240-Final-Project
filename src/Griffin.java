import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Griffin extends Enemy {
    private String type = "Gilded Griffin";
    private int vitality = 45;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,17);
        if (p.damage(damDealt, rng)) {
            return("Talon strike hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the talon strike!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(17,26);
        if (p.damage(damDealt,rng)) {
            return("Beak peck hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged beak peck!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,6) != 1) {
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
