import java.util.Random;

//Inherited from Enemy
public class Boar extends Enemy {
    private String type = "Bustling Boar";
    private int vitality = 35;
    private final int maxVitality = getVitality();
    // randomized if the enemy hits the player for a regular attack
    @Override
    public String attack(Player p, Random rng) {
        int damDealt = rng.nextInt(6,11);
        if (p.damage(damDealt, rng)) {
            return("Tusk Swipe hits! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the tusk swipe!\n");
        }
    }
    // randomized if the enemy hits if the player for the special attack
    @Override
    public String specAttack(Player p, Random rng) {
        int damDealt = rng.nextInt(11,18);
        if (p.damage(damDealt, rng)) {
            return("Hog Charge hits!!! -" + damDealt + "\n");
        } else {
            return(p.getName() + " dodged the hog charge!\n");
        }
    }
    //if the enemy dodges your hit
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) != 1) {
            vitality -= dam;
            return true;
        } else {
            return false;
        }
    }
    //return the enemy
    @Override
    public String getType() {
        return type;
    }
    // return the health
    @Override
    public int getVitality() {
        return vitality;
    }
    //return the max health
    public int getMaxVitality() {
        return maxVitality;
    }
}
