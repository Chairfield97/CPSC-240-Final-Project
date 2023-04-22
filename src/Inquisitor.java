import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Inquisitor extends Enemy {
    private String type = "Impervious Inquisitor";
    private int vitality = 90;
    private final int maxVitality = getVitality();
    //Enemy randomized damage on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,23);
        if (p.damage(damDealt, rng)) {
            return("Brute bludgeoning hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the brute bludgeoning!\n");
        }
    }
    //Enemy randomized special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(23,39);
        if (p.damage(damDealt,rng)) {
            return("Dark magic spell hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the dark magic spell!\n");
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
