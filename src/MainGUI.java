import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Random;

import static javax.swing.BorderFactory.createTitledBorder;
// was to use the mainGui as the main menu
public class MainGUI {

    private String userName;

    private int health;

    private boolean battle = true;

    private Random rng = new Random();

    private int ranNum = rng.nextInt(10);

    int rando = 0;

    private JTextField text;

    private Player p;
    // instuctor to add how much health
    public MainGUI(String userName){
        this.userName = userName;
        health = 30;
    }
    //to get username
    public String getUserName(){
        return userName;
    }
    //instructor to get Item and carry limit and put that in a Gui
    public MainGUI(Player p) {
        this.p = p;
        ItemGenerator.itemSelection("Items.txt"); //passes import file to be imported
        Random rng = new Random();
        int carryLimit = rng.nextInt(69,110); //generates random carry limit
        Inventory inventory = new Inventory(carryLimit);    //passes carry limit to inventory

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
//        userName = text.getText();
////        ButtonListener P1 = new ButtonListener(text.getText());
//        JLabel usrName = new JLabel(userName);
//
//        //label for title and username
//        JLabel label = new JLabel("Welcome to your" +
//                " adventure " + userName);

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
//        for (int i = 0; i < 10; i++) {
//           System.out.println("no" + rando );
//           rando++;
//        }


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));

        JPanel bottomPanel2 = new JPanel();
        bottomPanel2.setLayout(new BoxLayout(bottomPanel2, BoxLayout.PAGE_AXIS));
        //button will be pressed
        //Action to print something
        //close to close

        JButton printInv = new JButton("Print inventory");
        printInv.addActionListener(new ActionListener() {
            //add a button to print inventory
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.print();
            }
        });

        JButton addItem = new JButton("Add random item");
        addItem.addActionListener(new ActionListener() {
            //added a button to add a random Item
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.add(ItemGenerator.generate());
            }
        });

        JButton battle = new JButton("To battle!");
        battle.addActionListener(new ActionListener() {
           //added a button to battle
            @Override
            public void actionPerformed(ActionEvent e) {
                //new Battle(inventory, p, rng ,pw);
                System.out.println(p.getName() + ": " + p.getVitality());
            }
        });

        JButton dropItem = new JButton("Drop item");
        dropItem.addActionListener(new ActionListener() {
            //added a button to drop Item
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.drop();
            }
        });


        JButton equipW = new JButton("Equip weapon");
        equipW.addActionListener(new ActionListener() {
            //added a button to equip weapon
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.equipWeapon();
            }
        });

        JButton equipA = new JButton("Equip armor");
        equipA.addActionListener(new ActionListener() {
            //added a button to equip armor
            @Override
            public void actionPerformed(ActionEvent e) {
                inventory.equipArmor();
            }
        });

        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            //added a button to close
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

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
//        topPanel.add(label);

        topPanel.add(scrollPane);


        bottomPanel.add(battle);
        bottomPanel.add(printInv);
        bottomPanel.add(addItem);
        bottomPanel.add(dropItem);

        bottomPanel2.add(equipW);
        bottomPanel2.add(equipA);
        bottomPanel2.add(close);

        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
//        contentPane.add(bottomPanel, BorderLayout.PAGE_END);
        contentPane.add(bottomPanel, BorderLayout.WEST);
        contentPane.add(bottomPanel2, BorderLayout.EAST);

        frame.setContentPane(contentPane);
        //display
        frame.pack();
        frame.setSize(400, 340);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //gets text from first GUI
    public MainGUI(JTextField text) {
        this.text = text;
    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
////        Player p = Player.instance();
//        ItemGenerator.itemSelection("Items.txt"); //passes import file to be imported
//        Random rng = new Random();
//        int carryLimit = rng.nextInt(69,110); //generates random carry limit
//        Inventory inventory = new Inventory(carryLimit);    //passes carry limit to inventory
//
//        JFrame frame = new JFrame("Adventure");
//
//        //sets exit radio button to exit
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel contentPane = new JPanel();
//        contentPane.setLayout(new BorderLayout(5,5));
//
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new GridLayout(0,1,5,5));
//
//        JPanel centerPanel = new JPanel();
//        centerPanel.setLayout(new GridLayout(0,1,5,5));
//
//        //grabs name from user input
//        //figure out how to transfer name to BattleGUI
//        userName = text.getText();
////        ButtonListener P1 = new ButtonListener(text.getText());
//        JLabel usrName = new JLabel(userName);
//
//        //label for title and username
//        JLabel label = new JLabel("Welcome to your" +
//                " adventure " + userName);
//
//        //text area for events and actions
//        JTextArea textBox = new JTextArea(5, 10);
//        textBox.setWrapStyleWord(true);
//        textBox.setLineWrap(true);
////        textBox.setBounds(100,350,300,30);
//
//
//        //goodness all this just to print to JTextArea
//        OutputStream out = new OutputStream() {
//            @Override
//            public void write(int b) throws IOException {
//            }
//        };
//
//        class TextPrint extends PrintStream {
//            public TextPrint(OutputStream out) {
//                super(out);
//            }
//            @Override
//            public void println(String x) {
////                textBox.setText(x);
//                textBox.append(x +"\n");
//            }
//        };
//
//        TextPrint print = new TextPrint(out);
//        System.setOut(print);
//        //prints out no + number - test
////        for (int i = 0; i < 10; i++) {
////           System.out.println("no" + rando );
////           rando++;
////        }
//
//
//        JPanel bottomPanel = new JPanel();
//
//        JPanel bottomPanel2 = new JPanel();
//
//        //button will be pressed
//        //Action to print something
//        //close to close
//
//        JButton printInv = new JButton("Print inventory");
//        printInv.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inventory.print();
//            }
//        });
//
//        JButton addItem = new JButton("Add random item.");
//        addItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inventory.add(ItemGenerator.generate());
//            }
//        });
//
//        JButton battle = new JButton("To battle!");
//        battle.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Battle(inventory, p, rng);
//                System.out.println(p.getName() + ": " + p.getVitality());
//            }
//        });
//
//        JButton dropItem = new JButton("Drop item");
//        dropItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inventory.drop();
//            }
//        });
//
//        JButton equipW = new JButton("Drop item");
//        equipW.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inventory.equipWeapon();
//            }
//        });
//
//        JButton equipA = new JButton("Drop item");
//        equipA.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                inventory.equipArmor();
//            }
//        });
//
//        JButton close = new JButton("Close");
//        close.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.dispose();
//            }
//        });
//
//        //Scroll bar on side of textBox
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setViewportView(textBox);
//        scrollPane.setBorder(createTitledBorder("Adventure"));
//
//        //Main GUI for actions
//        BoxLayout mainLayout =
//                new BoxLayout(frame.getContentPane(),
//                        BoxLayout.Y_AXIS);
//
//        //adding layout
////        frame.getContentPane().setLayout(mainLayout);
//        frame.setContentPane(contentPane);
//
//        //adding Title
////        frame.getContentPane().add(label);
//
//        //adding textBox
////        frame.getContentPane().add(textBox);
//        //added textBox WITH scroll bar
////        frame.getContentPane().add(scrollPane);
//        //adds username above buttons
////        frame.getContentPane().add(usrName);
//
//        //adds buttons
////        topPanel.add(label);
//
//        topPanel.add(scrollPane);
//
//
//        bottomPanel.add(battle);
//        bottomPanel.add(printInv);
//        bottomPanel.add(addItem);
//        bottomPanel.add(dropItem);
//
//        bottomPanel2.add(equipW);
//        bottomPanel2.add(equipA);
//        bottomPanel2.add(close);
//
//        contentPane.add(topPanel, BorderLayout.PAGE_START);
//        contentPane.add(centerPanel, BorderLayout.CENTER);
////        contentPane.add(bottomPanel, BorderLayout.PAGE_END);
//        contentPane.add(bottomPanel, BorderLayout.WEST);
//        contentPane.add(bottomPanel2, BorderLayout.EAST);
//
//        frame.setContentPane(contentPane);
//        //display
//        frame.pack();
//        frame.setSize(400, 340);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }

    public void textBox(){

    }
}
