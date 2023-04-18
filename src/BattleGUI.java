import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;
import javax.swing.text.*;

class BattleGUI extends JDialog {
    JFrame frame = new JFrame();
    private JButton btnAttack  = new JButton("Attack");
    private JButton btnSpecAttack = new JButton("Special Attack");
    BufferedImage weapImage;
    BufferedImage armImage;
    BufferedImage enemImage;
    private JTextPane prompt = new JTextPane();
    private JLabel namelbl = new JLabel();
    private JLabel vitalitylbl = new JLabel();
    private JLabel powerlbl = new JLabel();
    private JLabel speciallbl = new JLabel();
    private JLabel enemylbl = new JLabel();
    private JLabel enemyVitlbl = new JLabel();
    private JLabel extraSpace = new JLabel("\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
    private JPanel contentPane = new JPanel();
    private JPanel topPanel  = new JPanel();
    private JPanel centerPanel  = new JPanel();
    private JPanel centerPanel2 = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JScrollBar scrollBar;
    //PrintStream promptOutput = new PrintStream(new PromptOutputStream(prompt));
//    PrintStream stdout = System.out;
//    Style promptStyle = prompt.addStyle("Style", null);
    JScrollPane promptScroll;
    private Inventory inventory;
    private Enemy enemy;
    private Player player;
    private Random rng;



    public BattleGUI(Inventory inventory, Player player, Enemy enemy, Random rng) {
        setModal(true);
        frame.setTitle("Battle");
        frame.setSize(720,600); //height was 900
        frame.setLocation(new Point(300,200));
        frame.setLayout(null);
        frame.setBackground(Color.darkGray);
        this.inventory = inventory;
        this.player = player;
        this.enemy = enemy;
        this.rng = rng;
        initComponent(inventory, player, enemy);
        initEvent();
    }

    private void initComponent(Inventory inventory, Player player, Enemy enemy) {

        enemylbl.setText(enemy.getType());
        enemyVitlbl.setText("Vitality: " + (enemy.getMaxVitality()));
        namelbl.setText(player.getName());
        speciallbl.setText("Special Cooldown: " + player.getSpecCooldown());
        //player.addArmor(inventory.getEquippedArmor());
        vitalitylbl.setText("Vitality: " + player.getVitality());
        powerlbl.setText("Power: " + inventory.getEquippedWeapon().getStrength());

        btnAttack.setBounds(200, 300, 160, 25);
        btnSpecAttack.setBounds(200, 330, 160, 25);

        JLabel armLabel;
        try {
            armImage = ImageIO.read(new File("pictures/" + inventory.getEquippedArmor() +".png"));
            armLabel = new JLabel(new ImageIcon(armImage));
        } catch (IOException e) {
            throw new RuntimeException();
        }

        JLabel weapLabel;
        try {
            weapImage = ImageIO.read(new File("pictures/" + inventory.getEquippedWeapon() +".png"));
            weapLabel = new JLabel(new ImageIcon(weapImage));

        } catch (IOException e) {
            throw new RuntimeException();
        }
        JLabel enemLabel;
        try {
            enemImage = ImageIO.read(new File("pictures/" + enemy.getClass().getSimpleName() + ".png"));
            enemLabel = new JLabel(new ImageIcon(enemImage));

        } catch (IOException e) {
            throw new RuntimeException();
        }
        armLabel.setBounds(0,5,150,400);
        weapLabel.setBounds(155,5,200,250);
        enemLabel.setBounds(400,5,400, 500);

//        prompt.setBounds(0,555,1000,305);

        namelbl.setBounds(10, 425, 100, 20);
        vitalitylbl.setBounds(10, 445, 100, 20);
        powerlbl.setBounds(10, 465, 100, 20);
        speciallbl.setBounds(10, 485, 200, 20);
        extraSpace.setBounds(10,4855,200,20);

        enemylbl.setBounds(680,425,120,20);
        enemyVitlbl.setBounds(680,445,120,20);

        // Input ALT+A or ALT+S
        btnAttack.setMnemonic(KeyEvent.VK_A);
        btnSpecAttack.setMnemonic(KeyEvent.VK_S);

        prompt.setFont(new Font("Roman", Font.ITALIC, 16));
        promptScroll  = new JScrollPane(prompt);
        promptScroll.setPreferredSize(new Dimension(500, 115));
//        promptScroll = new JScrollPane(prompt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        promptScroll.setViewportView(prompt);


        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.add(armLabel);
//        frame.add(weapLabel);
//        frame.add(enemLabel);
//        frame.add(btnAttack);
//        frame.add(btnSpecAttack);

//        frame.add(prompt);
//        frame.getContentPane().add(promptScroll);
//        frame.add(namelbl);
//        frame.add(vitalitylbl);
//        frame.add(powerlbl);
//        frame.add(speciallbl);
//        frame.add(enemylbl);
//        frame.add(enemyVitlbl);

        topPanel.add(armLabel);
        topPanel.add(weapLabel);
        topPanel.add(enemLabel);

        centerPanel.add(namelbl);
        centerPanel.add(vitalitylbl);
        centerPanel.add(powerlbl);
        centerPanel.add(speciallbl);
        centerPanel.add(extraSpace);
        centerPanel2.add(enemylbl);
        centerPanel2.add(enemyVitlbl);
//        centerPanel.add(enemylbl);
//        centerPanel.add(enemyVitlbl);

        bottomPanel.add(promptScroll);
        scrollBar = promptScroll.getVerticalScrollBar();
        bottomPanel.add(btnAttack);
        bottomPanel.add(btnSpecAttack);

        contentPane.add(topPanel, BorderLayout.PAGE_START);
//        contentPane.setBounds(00,400,120,20);
        contentPane.add(centerPanel, BorderLayout.WEST);
        contentPane.add(centerPanel2, BorderLayout.EAST);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);
        frame.setContentPane(contentPane);
        String message = "You encountered a " + enemy.getType() + "!\n";
        results(message);
        appendToPane(prompt, message, Color.black);
        frame.setVisible(true);
    }

    private void initEvent(){

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                frame.dispose();
            }
        });

        btnAttack.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                btnAttackClick();
            }
        });

        btnSpecAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSpecClick();
            }
        });
    }

    private boolean btnAttackClick(){
        //System.setOut(promptOutput);
//        StyleConstants.setForeground(promptStyle, Color.black);
        String attack = player.attack(enemy, inventory.getEquippedWeapon(), rng);
        results(attack);
        if ( attack.contains("hit")) {
            appendToPane(prompt, attack, Color.green);
        } else {
            appendToPane(prompt, attack, Color.black);
        }
        frame.setVisible(true);
        sleep();
        if (enemy.getVitality() > 0) {
            String enemAttack = enemy.brawl(player, rng);
            results(enemAttack);
            if (!enemAttack.contains("hit")) {
                appendToPane(prompt, enemAttack, Color.black);
            } else {
                appendToPane(prompt, enemAttack, Color.red);
            }
        }
        frame.setVisible(true);
        return fight();
        //prompt.getGraphics();
        //System.setOut(stdout);
    }

    private boolean btnSpecClick(){
        //System.setOut(promptOutput);
//        StyleConstants.setForeground(promptStyle, Color.BLACK);
        String attack = player.specAttack(enemy, inventory.getEquippedWeapon(), rng);
        results(attack);
        if (attack.contains("Special")) {
            appendToPane(prompt, attack, Color.BLUE);
        } else if (attack.contains("Standard")) {
            appendToPane(prompt, attack, Color.GREEN);
        } else {
            appendToPane(prompt, attack, Color.BLACK);
        }
        frame.setVisible(true);
        sleep();
        if (enemy.getVitality() > 0) {
            String enemSpec = enemy.brawl(player, rng);
            results(enemSpec);
            if (!enemSpec.contains("hit")) {
                appendToPane(prompt, enemy.brawl(player, rng), Color.BLACK);
            } else {
                appendToPane(prompt, enemy.brawl(player, rng), Color.RED);
            }
        }
        frame.setVisible(true);
        return fight();
        //prompt.getGraphics();
        //System.setOut(stdout);
        //System.out.println("print back to console");

    }
    private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);

    }
    public boolean fight() {

//        do {
//
//            if (enemy.getVitality() > 0) {
//                enemy.brawl(player, rng);
//            }
//        } while (player.getVitality() > 0 && enemy.getVitality() > 0);
        enemyVitlbl.setText("Vitality: " + (enemy.getVitality()));
        vitalitylbl.setText("Vitality: " + (player.getVitality()));
        speciallbl.setText("Special Cooldown: " + player.getSpecCooldown());
        enemyVitlbl.setVisible(true);
        vitalitylbl.setVisible(true);
        speciallbl.setVisible(true);

        if (player.getVitality() <= 0) {
            String message = player.getName() + " was defeated by " + enemy.getType();
            results(message + "\n\n");
            appendToPane(prompt, message, Color.red);
            sleep();
            JOptionPane.showMessageDialog(frame, "You were defeated by the " + enemy.getType());
            WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
            System.out.println("\nYour adventure ends here " + player.getName());
            System.exit(0);
        } else if (enemy.getVitality() <= 0) {
            String message = player.getName() + " defeated the " + enemy.getType();
            appendToPane(prompt, message, Color.green);
            results(message + "\n\n");
            sleep();
            JOptionPane.showMessageDialog(frame, "You defeated the " + enemy.getType());
            WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
            return true;
        }
        return false;
    }
    public void results(String result) {
        try {
            FileOutputStream fileCreate = new FileOutputStream("Results.txt", true);
            PrintWriter pw = new PrintWriter(fileCreate);
            pw.print(result);
            pw.close();
        } catch (IOException e) {
            System.out.println("Could not save the results");
        }
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}