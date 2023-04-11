import javax.swing.*;
import java.util.Random;

public class Cyclops implements Enemy {
    private String type="Close minded Cyclops";
    private int vitality=45;
    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(2,3), rng)) {
            System.out.println("Clubbin time");
        } else {
            System.out.println(p.getName() + " dodged the Clubbin time!");
        }
    }


    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(20,22),rng)) {
            System.out.println("punch and kick!!!");
        } else {
            System.out.println(p.getName() + " dodged punch and kick!");
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
    public String Image(JComponent mygamePieace) {
        JComponent mygamePieace = new JComponent(656, 30);
    }
}
