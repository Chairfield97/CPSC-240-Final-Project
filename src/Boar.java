import java.util.Random;


public class Boar extends Enemy {
    private String type = "Bustling Boar";
    private int vitality = 30;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,10);
        if (p.damage(damDealt, rng)) {
            return("Tusk Swipe hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the tusk swipe!\n");
        }
    }
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(11,18);
        if (p.damage(damDealt, rng)) {
            return("Hog Charge hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the hog charge!\n");
        }
    }
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getVitality() {
        return vitality;
    }
    public int getMaxVitality() {
        return maxVitality;
    }
}
