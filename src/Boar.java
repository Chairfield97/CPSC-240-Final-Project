import java.util.Random;

public class Boar implements Enemy {
    private String type = "Bustling Boar";
    private int vitality = 30;
    @Override
    public void attack(Player p, Random rng) {
        System.out.println("Tusk Swipe!");
        p.damage(rng.nextInt(4,8));
    }

    @Override
    public void specAttack(Player p, Random rng) {
        System.out.println("Hog Charge!!!");
        p.damage(rng.nextInt(12,18));
    }
    public void damage(int dam) {
        vitality -= dam;
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
}
