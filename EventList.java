import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class EventList {
    private ArrayList<Event>events;
    public boolean save(PrintWriter pw){
        pw.print(events);
        return false;
    }
    public boolean load(Scanner filescan){
        (filescan.next())
        return false;
    }
    public boolean add(Event event){

        event= new Event(event.prompt,event.reward);
        return false;
    }
}
