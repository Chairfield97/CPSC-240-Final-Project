import java.util.Random;

public class Summoner extends Enemy {
    private String type = "Smug Summoner";
    private int vitality = 42;
    private final int maxVitality = getVitality();

    @Override
    public String attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(3,9), rng)) {
            return("Bipity boopity boo hits");
        } else {
            return(p.getName() + " dodged the Bipity boopity boo!");
        }
    }

    @Override
    public String specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(14,20),rng)) {
            return("Oogie boogie summon hits!!!");
        } else {
            return(p.getName() + " dodged Oogie boogie!");
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
