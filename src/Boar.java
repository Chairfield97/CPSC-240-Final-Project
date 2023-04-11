import javax.swing.*;
import java.util.Random;

public class Boar implements Enemy {
    private String type = "Bustling Boar";
    private int vitality = 30;
    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(4,9), rng)) {
            System.out.println("Tusk Swipe hits!");
        } else {
            System.out.println(p.getName() + " dodged the tusk swipe!");
        }
    }
    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(12,18),rng)) {
            System.out.println("Hog Charge hits!!!");
        } else {
            System.out.println(p.getName() + " dodged the hog charge!");
        }
    }
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
    public JPanel Image(JPanel myGamePiece) {
        return null;
    }


}
