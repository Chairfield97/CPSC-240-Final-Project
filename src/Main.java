import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);
        Player p = Player.instance(playerInput);
        ItemGenerator.itemSelection("Items.txt");
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110);
        Inventory inventory = new Inventory(carryLimit);
        //for (int i = 0; i < 1; i++) {
        //inventory.add(ItemGenerator.generate());
        //}
        //inventory.print();
        p.addArmor(inventory.getEquippedArmor());
        System.out.println(p.getName() + ": " + p.getVitality());
        Battle b = new Battle();
        Grizzly g = new Grizzly();
        b.fight(inventory, p, g, playerInput, rng);

        //GUI name input creation
        // create and set up the window.
        JFrame frame = new JFrame("Name Entry");

        // make the program close when the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout mainLayout =
                new BoxLayout(frame.getContentPane(),
                        BoxLayout.Y_AXIS);

        // add a button object
//        JButton button = new JButton("Push Me!");
//        button.addActionListener(new ButtonListener());
        JLabel nameLabel = new JLabel("Enter your name");

        JTextField field = new JTextField();
        field.addActionListener(new MainGUI(field));
//        field.addActionListener(new Battle(field));
        field.addActionListener(new MainGUI() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().setLayout(mainLayout);

//        frame.getContentPane().add(button);
        frame.getContentPane().add(nameLabel);
        frame.getContentPane().add(field);

        //display
        frame.pack();
        frame.setSize(200,80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
