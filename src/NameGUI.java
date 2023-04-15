import javax.swing.*;
import java.awt.event.ActionEvent;

public class NameGUI {
    public static void main(String[] args) {
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
