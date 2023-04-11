import javax.swing.*;
import java.util.Random;
public class Grizzly implements Enemy {
    private String type="Grandiose Grizzly";
    private int vitality=50;
    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(5,7), rng)) {
            System.out.println("Grizzly slice and dice");
        } else {
            System.out.println(p.getName() + " dodged the slice and dice!");
        }
    }

    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(14,16),rng)) {
            System.out.println("Unbearable charge!!!");
        } else {
            System.out.println(p.getName() + " dodged Unbearable charge!");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) == 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void defend() {

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getVitality() {
        return vitality;
    }

    @Override
    public String Image(JComponent myGamePiece) {
        return null;
    }


}
