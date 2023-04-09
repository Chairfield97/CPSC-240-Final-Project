import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Event {
    protected int progress;
    protected String prompt;

    protected Item reward;
    public Event(String prompt, Item reward){
        this.prompt=prompt;
        this.reward=reward;

    }
    public void prompt(){

    }
    public void save(PrintWriter pw){
        pw.print(progress+"\n");
        pw.print(prompt+"\n");
        pw.print(reward.getName()+"\n");
        pw.print(reward.getItemType()+"\n");
        pw.print(reward.getWeight()+"\n");
        pw.print(reward.getStrength()+"\n");
    }
    public Item reward(){

        return null;
    }

    public boolean Load(Scanner file){

         this.progress= Integer.parseInt(file.nextLine());
         this.prompt=file.nextLine();

         //this.reward=new Item(ItemType.Weapon,String name, );
        return false;
    }

    @Override
    public String toString() {

        return null;
    }
}
