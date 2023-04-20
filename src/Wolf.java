import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Wolf extends Enemy {
    private String type = "Ravenous Wolf";
    private int vitality = 30;
    private final int maxVitality = getVitality();
    // // Enemy randomizer dealt damage attack for player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(4,9);
        if (p.damage(damDealt, rng)) {
            return("Wolf bite hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the wolf bite!\n");
        }
    }
    // Enemy randomizer dealt damage special attack for player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,16);
        if (p.damage(damDealt,rng)) {
            return("Throat clamp hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged Slash and dash!\n");
        }
    }
    //Enemy randomizer to dodge player attacks
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,2) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }
    // return type
    @Override
    public String getType() {
        return type;
    }
    // return health
    @Override
    public int getVitality() {
        return vitality;
    }
    //return max health
    public int getMaxVitality() {
        return maxVitality;
    }

}
