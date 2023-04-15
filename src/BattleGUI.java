import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.text.*;

class BattleGUI {

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
    PrintStream promptOutput = new PrintStream(new PromptOutputStream(prompt));
    PrintStream stdout = System.out;
    Style promptStyle = prompt.addStyle("Style", null);
    JScrollPane promptScroll;
    Inventory inventory;
    Enemy enemy;



    public BattleGUI(Inventory inventory, Player player, Enemy enemy){
        frame.setTitle("Battle");
        frame.setSize(800,900);
        frame.setLocation(new Point(300,200));
        frame.setLayout(null);
        frame.setResizable(false);
        this.inventory = inventory;
        this.enemy = enemy;
        initComponent(inventory, player, enemy);
        initEvent();
    }

    private void initComponent(Inventory inventory, Player player, Enemy enemy) {

        namelbl.setText(player.getName());
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

        prompt.setBounds(0,555,1000,305);

        namelbl.setBounds(20, 425, 100, 20);
        vitalitylbl.setBounds(20, 445, 100, 20);
        powerlbl.setBounds(20, 465, 100, 20);

        // Input ALT+A or ALT+S
        btnAttack.setMnemonic(KeyEvent.VK_A);
        btnSpecAttack.setMnemonic(KeyEvent.VK_S);

        promptScroll = new JScrollPane(prompt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(armLabel);
        frame.add(weapLabel);
        frame.add(enemLabel);
        frame.add(btnAttack);
        frame.add(btnSpecAttack);

        frame.add(prompt);
        frame.getContentPane().add(promptScroll);
        frame.add(namelbl);
        frame.add(vitalitylbl);
        frame.add(powerlbl);
        frame.setVisible(true);

    }

    private void initEvent(){

        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e){
                System.exit(1);
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
        StyleConstants.setForeground(promptStyle, Color.green);
        String attack =  ("Standard attack\n");
        appendToPane(prompt, attack, Color.green);

//        try {
//            sPrompt.insertString(sPrompt.getLength(), attack, promptStyle);
//            System.out.println();
//
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
        //prompt.setText("Standard attack!");
        //prompt.setVisible(true);
        prompt.getGraphics();
        System.setOut(stdout);
    }

    private void btnSpecClick(){
        System.setOut(promptOutput);
        //StyleConstants.setForeground(promptStyle, Color.black);
        String attack = ("Special attack\n");
        appendToPane(prompt, attack, Color.blue);
//        try {
//            sPrompt.insertString(sPrompt.getLength(), attack, promptStyle);
//            System.out.println();
//
//        } catch (BadLocationException e) {
//            e.printStackTrace();
//        }
        //prompt.setText("Special attack!");
        //prompt.setVisible(true);
        //prompt.getGraphics();
        System.setOut(stdout);
        System.out.println("Back to console");

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

}