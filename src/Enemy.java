import javax.swing.*;
import java.util.Random;

public interface Enemy {
    public void attack(Player p, Random rng);
    public void specAttack(Player p, Random rng);
    public boolean damage(int dam, Random rng);
    public void defend();
    public String getType();
    public int getVitality();
    public JPanel Image(JPanel myGamePiece);
}
