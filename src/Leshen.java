import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from Enemy
public class Leshen extends Enemy {
    private String type = "Lush Leshen";
    private int vitality = 55;
    private final int maxVitality = getVitality();
    //Enemy randomized damage attacks player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,18);
        if (p.damage(damDealt, rng)) {
            return("Branch swipe hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the branch swipe!\n");
        }
    }
    //Enemy randomized speacial attack damage player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(18,32);
        if (p.damage(damDealt,rng)) {
            return("Root strangle hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged root strangle!\n");
        }
    }
    // randomize if they dodge players attack
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,5) != 1) {
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
    //return health
    @Override
    public int getVitality() {
        return vitality;
    }
    //retrun max health
    public int getMaxVitality() {
        return maxVitality;
    }

}
