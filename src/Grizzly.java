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
    public void attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,12);
        if (p.damage(damDealt, rng)) {
            System.out.println(RED + "Paw slice and dice -" + damDealt + "\n");
            System.out.print(RESET);
        } else {
            System.out.println(p.getName() + " dodged the slice and dice!\n");
        }
    }

    @Override
    public void specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,20);
        if (p.damage(damDealt,rng)) {
            System.out.println(RED + "Unbearable charge!!! - " + damDealt + "\n");
            System.out.print(RESET);
        } else {
            System.out.println(p.getName() + " dodged Unbearable charge!\n");
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
