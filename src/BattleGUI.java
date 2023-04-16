import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.text.*;

class BattleGUI {

    JFrame frame = new JFrame();
    private JButton btnAttack  = new JButton("Attack");
    private JButton btnSpecAttack = new JButton("Special Attack");
    BufferedImage weapImage;
    BufferedImage armImage;
    BufferedImage enemImage;
    private JTextArea prompt = new JTextArea(5,40);
    private JLabel namelbl = new JLabel();
    private JLabel vitalitylbl = new JLabel();
    private JLabel powerlbl = new JLabel();
    private JLabel speciallbl = new JLabel();
    private JLabel enemylbl = new JLabel();
    private JLabel enemyVitlbl = new JLabel();
    private JPanel contentPane = new JPanel();
    private JPanel topPanel  = new JPanel();
    private JPanel centerPanel  = new JPanel();
    private JPanel centerPanel2 = new JPanel();
    private JPanel bottomPanel = new JPanel();
    PrintStream promptOutput = new PrintStream(new PromptOutputStream(prompt));
    PrintStream stdout = System.out;
//    Style promptStyle = prompt.addStyle("Style", null);
    JScrollPane promptScroll;
    private Inventory inventory;
    private Enemy enemy;
    private Player player;
    private Random rng;



    public BattleGUI(Inventory inventory, Player player, Enemy enemy, Random rng){
        frame.setTitle("Battle");
        frame.setSize(800,600); //height was 900
        frame.setLocation(new Point(300,200));
        frame.setLayout(null);
        frame.setResizable(false);
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
        player.addArmor(inventory.getEquippedArmor());
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

        namelbl.setBounds(20, 425, 100, 20);
        vitalitylbl.setBounds(20, 445, 100, 20);
        powerlbl.setBounds(20, 465, 100, 20);
        speciallbl.setBounds(20, 485, 200, 20);

        enemylbl.setBounds(680,425,100,20);
        enemyVitlbl.setBounds(680,445,100,20);

        // Input ALT+A or ALT+S
        btnAttack.setMnemonic(KeyEvent.VK_A);
        btnSpecAttack.setMnemonic(KeyEvent.VK_S);

        promptScroll  = new JScrollPane();
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
        centerPanel2.add(enemylbl);
        centerPanel2.add(enemyVitlbl);
//        centerPanel.add(enemylbl);
//        centerPanel.add(enemyVitlbl);

        bottomPanel.add(promptScroll);
        bottomPanel.add(btnAttack);
        bottomPanel.add(btnSpecAttack);

        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.WEST);
        contentPane.add(centerPanel2, BorderLayout.EAST);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);
        frame.setContentPane(contentPane);
        appendToPane(prompt, ("You encountered a " + enemy.getType() + "!\n"), Color.black);
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

    private void btnAttackClick(){
        System.setOut(promptOutput);
//        StyleConstants.setForeground(promptStyle, Color.black);
        String attack = player.attack(enemy, inventory.getEquippedWeapon(), rng);
        if ( attack.contains("hit")) {
            enemy.sleep();
            appendToPane(prompt, attack, Color.green);
        } else {
            appendToPane(prompt, attack, Color.black);
        }
        if (enemy.getVitality() > 0) {
            String enemAttack = enemy.brawl(player, rng);
            if (!enemAttack.contains("hit")) {
                enemy.sleep();
                appendToPane(prompt, enemAttack, Color.black);
            } else {
                enemy.sleep();
                appendToPane(prompt, enemAttack, Color.red);
            }
        }
        fight();
        prompt.getGraphics();
        System.setOut(stdout);
    }

    private void btnSpecClick(){
        //System.setOut(promptOutput);
//        StyleConstants.setForeground(promptStyle, Color.BLACK);
        String attack = player.specAttack(enemy, inventory.getEquippedWeapon(), rng);
        enemy.sleep();
        if (attack.contains("Special")) {
            appendToPane(prompt, attack, Color.BLUE);
        } else if (attack.contains("Standard")) {

            appendToPane(prompt, attack, Color.GREEN);
        } else {
            appendToPane(prompt, attack, Color.BLACK);
        }
        if (enemy.getVitality() > 0) {
            enemy.sleep();
            String enemSpec = enemy.brawl(player, rng);
            if (!enemSpec.contains("hit")) {
                appendToPane(prompt, enemy.brawl(player, rng), Color.BLACK);
            } else {
                appendToPane(prompt, enemy.brawl(player, rng), Color.RED);
            }
        }
        fight();
        //prompt.getGraphics();
        //System.setOut(stdout);
        //System.out.println("print back to console");

    }
    private void appendToPane(JTextArea tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
//        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
    public void fight() {

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
            enemy.sleep();
            appendToPane(prompt,player.getName() + " was defeated by " + enemy.getType(), Color.red);
//            enemy.sleep();
//            WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
//            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
        } else if (enemy.getVitality() <= 0) {
            enemy.sleep();
            appendToPane(prompt,player.getName() + " defeated the " + enemy.getType(), Color.green);
//            enemy.sleep();
//            WindowEvent closingEvent = new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
//            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);
        }
    }
}