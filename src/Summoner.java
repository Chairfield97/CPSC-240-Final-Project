import java.util.Random;
//inherited from enemy
public class Summoner extends Enemy {
    private String type = "Smug Summoner";
    private int vitality = 42;
    private final int maxVitality = getVitality();
    // Enemy randomizer dealt damage attack for player
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,12);
        if (p.damage(damDealt, rng)) {
            return("Bipity boopity boo hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the Bipity boopity boo!\n");
        }
    }
    // Enemy randomizer dealt damage special attack for player
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(17,28);
        if (p.damage(damDealt,rng)) {
            return("Oogie boogie summon hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged Oogie boogie!\n");
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
    // return type
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
