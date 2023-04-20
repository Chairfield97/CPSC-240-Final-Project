import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Skeleton extends Enemy {
    private String type = "Skeletal Warrior";
    private int vitality = 40;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(8,13);
        if (p.damage(damDealt, rng)) {
            return("Sword slash hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the sword slash!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,19);
        if (p.damage(damDealt,rng)) {
            return("Elemental magic hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged elemental magic!\n");
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
