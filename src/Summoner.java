import java.util.Random;

public class Summoner extends Enemy {
    private String type = "Smug Summoner";
    private int vitality = 42;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,12);
        if (p.damage(damDealt, rng)) {
            return("Bipity boopity boo hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the Bipity boopity boo!\n");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(17,28);
        if (p.damage(damDealt,rng)) {
            return("Oogie boogie summon hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged Oogie boogie!\n");
        }
    }

    @Override
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,4) != 1) {
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
