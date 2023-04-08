import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner nameInput = new Scanner(System.in);
        Player p = Player.instance(nameInput);
        System.out.print(p.getName() + "\n");
        System.out.print(p.getVitality() + "\n");

    }

}
