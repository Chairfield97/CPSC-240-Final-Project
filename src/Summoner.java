

import javax.swing.*;
import java.util.Random;

public class Summoner implements Enemy {
    private String type="Smug Summoner";
    private int vitality=42;
    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(3,9), rng)) {
            System.out.println("Bipity boopity boo");
        } else {
            System.out.println(p.getName() + " dodged the Bipity boopity boo!");
        }
    }

    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(14,20),rng)) {
            System.out.println("Oogie boogie!!!");
        } else {
            System.out.println(p.getName() + " dodged Oogie boogie!");
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
