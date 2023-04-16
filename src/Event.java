import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Event {
    protected static int progress;
    protected String prompt;

    protected Item reward;
    public Event(String prompt, Item reward){
        this.prompt = prompt;
        this.reward = reward;

    }
    public void prompt(){
        FileInputStream file;
        try{
            file = new FileInputStream("Events.txt");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        FileInputStream f;
        this.progress = Integer.parseInt(file.nextLine());
        this.prompt = file.nextLine();
        try{
            f=new FileInputStream(String.valueOf(file));
            while(file.hasNext()){
                Event event = new Event(file.nextLine(), this.reward);
                file.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Boolean.parseBoolean(prompt);
    }

    @Override
    public String toString() {
        String quest= this.prompt;
        return prompt;
    }
}
