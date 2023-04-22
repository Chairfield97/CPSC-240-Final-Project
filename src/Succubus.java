import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Succubus extends Enemy {
    private String type = "Shapely Succubus";
    private int vitality = 70;
    private final int maxVitality = getVitality();
    //Enemy randomized damage on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,25);
        if (p.damage(damDealt, rng)) {
            return("Alluring gaze hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the alluring gaze!\n");
        }
    }
    //Enemy randomized special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(20,38);
        if (p.damage(damDealt,rng)) {
            return("Seductive kiss hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the seductive kiss!\n");
        }
    }
    //enemy randomized dodging player attacks
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }
    //return type
    @Override
    public String getType() {
        return type;
    }
    //return health
    @Override
    public int getVitality() {
        return vitality;
    }
    //return max health
    public int getMaxVitality() {
        return maxVitality;
    }

}
