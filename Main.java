import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance(playerInput);
        System.out.print(p.getName() + "\n");
        System.out.print(p.getVitality() + "\n");
        ItemGenerator.generate();
    }

}
