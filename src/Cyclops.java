import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from Enemy
public class Cyclops extends Enemy {
    private String type = "Close-Minded Cyclops";
    private int vitality = 65;
    private final int maxVitality = getVitality();
    // randomized enemy attack on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(11,19);
        if (p.damage(damDealt, rng)) {
            return("Clubbin time hit! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the Clubbin time!\n");
        }
    }
    //randomized enemy special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(19,27);
        if (p.damage(damDealt, rng)) {
            return("punch and kick hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged punch and kick!\n");
        }
    }
    // if enemy is able to dodge
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,5) != 1) {
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
