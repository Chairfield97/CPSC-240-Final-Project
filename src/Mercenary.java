import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherits from Mercenary
public class Mercenary extends Enemy {
    private String type = "Marksman Mercenary";
    private int vitality = 45;
    private final int maxVitality = getVitality();
    //Enemy randomized damaged attacks on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(7,19);
        if (p.damage(damDealt, rng)) {
            return("Arrow shot hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the arrow shot!\n");
        }
    }
    //Enemy randomized damage special attacks on players
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(19,27);
        if (p.damage(damDealt,rng)) {
            return("Crude explosive hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the crude explosive!\n");
        }
    }
    // randomized Enemy dodge player attacks
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
