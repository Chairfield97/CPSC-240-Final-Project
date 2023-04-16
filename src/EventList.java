import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EventList {

    private ArrayList <Enemy> enemies = new ArrayList<>();
    private ArrayList<Event>events = new ArrayList<>();
    private int progress;

    public ArrayList enemies() {
        enemies.add(new Summoner());
        enemies.add(new Boar());
        enemies.add(new Wolf());
        enemies.add(new Cyclops());
        enemies.add(new Grizzly());
        Collections.shuffle(enemies);
        return enemies;
    }
    public boolean save(PrintWriter pw){
        pw.print(events);
        return false;
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
