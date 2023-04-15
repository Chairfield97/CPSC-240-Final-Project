import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

import static javax.swing.BorderFactory.createTitledBorder;

public class MainGUI implements ActionListener {

    private String userName;

    private int health;

    private boolean battle = true;

    private Random rng = new Random();

    private int ranNum = rng.nextInt(10);

    int rando = 0;

    private JTextField text;


    public MainGUI(String userName){
        this.userName = userName;
        health = 30;
    }

    public String getUserName(){
        return userName;
    }

    public MainGUI() {

    }

    //gets text from first GUI
    public MainGUI(JTextField text) {
        this.text = text;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = new JFrame("Adventure");

        //sets exit radio button to exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(5,5));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(0,1,5,5));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,1,5,5));

        //grabs name from user input
        //figure out how to transfer name to BattleGUI
        userName = text.getText();
//        ButtonListener P1 = new ButtonListener(text.getText());
        JLabel usrName = new JLabel(userName);

        //label for title and username
        JLabel label = new JLabel("Welcome to your" +
                " adventure " + userName);

        //text area for events and actions
        JTextArea textBox = new JTextArea(5, 10);
        textBox.setWrapStyleWord(true);
        textBox.setLineWrap(true);
//        textBox.setBounds(100,350,300,30);


        //goodness all this just to print to JTextArea
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
            }
        };

        class TextPrint extends PrintStream {
            public TextPrint(OutputStream out) {
                super(out);
            }
            @Override
            public void println(String x) {
//                textBox.setText(x);
                textBox.append(x +"\n");
            }
        };

        TextPrint print = new TextPrint(out);
        System.setOut(print);
        //prints out no + number - test
        for (int i = 0; i < 10; i++) {
           System.out.println("no" + rando );
           rando++;
        }


        JPanel bottomPanel = new JPanel();

        //button will be pressed
        //Action to print something
        //close to close
        String action = "Action";
        JButton button = new JButton(action);
        button.addActionListener(new ActionButton());

        JButton save = new JButton("Save");
        save.addActionListener(new SaveButton());

        JButton close = new JButton("Close");
        close.addActionListener(new MainGUI() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JButton battle = new JButton("To battle!");
        battle.addActionListener(new BattleGUI());




        //Scroll bar on side of textBox
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(textBox);
        scrollPane.setBorder(createTitledBorder("Adventure"));

        //Main GUI for actions
        BoxLayout mainLayout =
                new BoxLayout(frame.getContentPane(),
                        BoxLayout.Y_AXIS);

        //adding layout
//        frame.getContentPane().setLayout(mainLayout);
        frame.setContentPane(contentPane);

        //adding Title
//        frame.getContentPane().add(label);

        //adding textBox
//        frame.getContentPane().add(textBox);
        //added textBox WITH scroll bar
//        frame.getContentPane().add(scrollPane);
        //adds username above buttons
//        frame.getContentPane().add(usrName);

        //adds buttons
        topPanel.add(label);

        centerPanel.add(scrollPane);

        bottomPanel.add(button);
        bottomPanel.add(battle);
        bottomPanel.add(save);
        bottomPanel.add(close);

        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        //display
        frame.pack();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void textBox(){

    }
}
