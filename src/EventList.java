import javax.swing.*;
import java.io.PrintWriter;
import java.util.*;
// the multiple enemeies
public class EventList {

    private ArrayList <Enemy> enemies = new ArrayList<>(Arrays.asList(new Inquisitor(), new Leshen(), new Griffin(), new Mercenary(), new Skeleton(), new Bandit(), new Wolf(), new Summoner(), new Grizzly(), new Boar(), new Cyclops()));
    private ArrayList<String> events = new ArrayList<>();
    private int progress;
   //pops up if you defeated all enemies good luck with that though
    public Enemy enemySpawn(Random rng) {
        if (enemies.size()==0) {
            JOptionPane.showMessageDialog(null, "Congratulations you defeated all enemies!!!");
            System.exit(0);
        }
        return enemies.remove(rng.nextInt(0, getNumEnemies()));
    }
    // Supposed to save the events
    public boolean save(PrintWriter pw){
        pw.print(events);
        return false;
    }
    // Get how enemies are left
    public int getNumEnemies() {
        return enemies.size();
    }
    // load the scanner for events back in
    public boolean load(Scanner filescan){
        //(filescan.next());
        return false;
    }
    //add the events
    public boolean add(Event event){

        event = new Event(event.prompt,event.reward);
        return false;
    }
}
