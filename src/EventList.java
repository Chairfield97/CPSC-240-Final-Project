import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;

public class EventList {

    private ArrayList <Enemy> enemies = new ArrayList<>(Arrays.asList(new Inquisitor(), new Leshen(), new Griffin(), new Mercenary(), new Skeleton(), new Bandit(), new Wolf(), new Summoner(), new Grizzly(), new Boar(), new Cyclops()));
    private ArrayList<String> events = new ArrayList<>();
    private int progress;

    public Enemy enemySpawn(Random rng) {
        if (enemies.size()==0) {
            JOptionPane.showMessageDialog(null, "Congratulations you defeated all enemies!!!");
            System.exit(0);
        }
        return enemies.remove(rng.nextInt(0, getNumEnemies()));
    }

    public boolean save(PrintWriter pw){
        pw.print(events);
        return false;
    }
    public int getNumEnemies() {
        return enemies.size();
    }
    public boolean load(Scanner filescan){
        //(filescan.next());
        return false;
    }
    public boolean add(Event event){

        event = new Event(event.prompt,event.reward);
        return false;
    }
}
