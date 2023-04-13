import java.util.Random;


public class Boar extends Enemy {
    private String type = "Bustling Boar";
    private int vitality = 30;
    private final int maxVitality = getVitality();

    @Override
    public void attack(Player p, Random rng) {
        if (p.damage(rng.nextInt(4,9), rng)) {
            System.out.println("Tusk Swipe hits!\n");
        } else {
            System.out.println(p.getName() + " dodged the tusk swipe!\n");
        }
    }
    @Override
    public void specAttack(Player p, Random rng) {
        if (p.damage(rng.nextInt(12,18), rng)) {
            System.out.println(RED + "Hog Charge hits!!!\n");
        } else {
            System.out.println(p.getName() + " dodged the hog charge!\n");
        }
    }
    public boolean damage(int dam, Random rng) {
        if (rng.nextInt(0,3) == 1) {
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
