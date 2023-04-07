import java.util.logging.Logger;

public class Player extends Logger {
    private static final String resourceBundleName = null ;
    private static final String name = null;
    private int vitality;
    private static Logger theInstance=null;

    protected Player() {
        super(name, resourceBundleName);
    }


    public static synchronized Logger instance(){
        if(theInstance==null){
            theInstance= new Player();
        }
        return theInstance;
    }

    public int getVitality() {
        return vitality;
    }
    public String getName(){

        return name;
    }
    public void attack(Enemy e){

    }
    public void specAttack(Enemy e){

    }
}
