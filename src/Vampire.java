import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Vampire extends Enemy {
    private String type = "Vigorous Vampire";
    private int vitality = 58;
    private final int maxVitality = getVitality();
    //Enemy randomized damage on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(10,17);
        if (p.damage(damDealt, rng)) {
            return("Claw slash hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the claw slash!\n");
        }
    }
    //Enemy randomized special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(17,30);
        if (p.damage(damDealt,rng)) {
            return("Fang blood siphon hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the fang blood siphon!\n");
        }
    }
    //enemy randomized dodging player attacks
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,2) != 1) {
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
