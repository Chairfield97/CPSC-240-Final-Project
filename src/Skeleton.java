import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Skeleton extends Enemy {
    private String type = "Skeletal Warrior";
    private int vitality = 40;
    private final int maxVitality = getVitality();
    // Enemy randomizer dealt damage attack for player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(8,13);
        if (p.damage(damDealt, rng)) {
            return("Sword slash hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the sword slash!\n");
        }
    }
    // Enemy randomizer dealt damage special attack for player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(13,19);
        if (p.damage(damDealt,rng)) {
            return("Elemental magic hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged elemental magic!\n");
        }
    }
    //Enemy randomizer to dodge player attacks
    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) != 1) {
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
