import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
//inherited from enemy
public class Werewolf extends Enemy {
    private String type = "Whimsical Werewolf";
    private int vitality = 55;
    private final int maxVitality = getVitality();
    //Enemy randomized damage on player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,19);
        if (p.damage(damDealt, rng)) {
            return("Claw scratch hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the claw scratch!\n");
        }
    }
    //Enemy randomized special attack on player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(19,32);
        if (p.damage(damDealt,rng)) {
            return("Devouring lunge hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the devouring lunge!\n");
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
