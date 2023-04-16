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
        if (p.damage(rng.nextInt(2,3), rng)) {
            return("Clubbin time hit"+"\n");
        } else {
            return(p.getName() + " dodged the Clubbin time!"+"\n");
        }
    }


    @Override
    public String specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(20,22),rng)) {
            return("punch and kick hits!!!"+"\n");
        } else {
            return(p.getName() + " dodged punch and kick!"+"\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) == 1) {
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
