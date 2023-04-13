import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Wolf extends Enemy {
    private String type = "Ravenous Wolf";
    private int vitality = 38;
    private final int maxVitality = getVitality();

    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(6,9), rng)) {
            System.out.println("Wolf bite");
        } else {
            System.out.println(p.getName() + " dodged the wolf bite!");
        }
    }

    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(13,18),rng)) {
            System.out.println("Slash and dash!!!");
        } else {
            System.out.println(p.getName() + " dodged Slash and dash!");
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
