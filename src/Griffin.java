import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherit from enemy
public class Griffin extends Enemy {
    private String type = "Gilded Griffin";
    private int vitality = 65;
    private final int maxVitality = getVitality();
    //Enemy randomized attacks on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,25);
        if (p.damage(damDealt, rng)) {
            return("Talon strike hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the talon strike!\n");
        }
    }
    // Enemy randomized special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(25,36);
        if (p.damage(damDealt,rng)) {
            return("Beak peck hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged beak peck!\n");
        }
    }
    //randomized if the enemy dodge
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,5) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }
    //returns type
    @Override
    public String getType() {
        return type;
    }
    //returns health
    @Override
    public int getVitality() {
        return vitality;
    }
    //returns max health
    public int getMaxVitality() {
        return maxVitality;
    }

}
