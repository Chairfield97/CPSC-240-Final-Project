import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleGUI implements ActionListener {

    private JTextField text;

    public BattleGUI() {

    }

    public BattleGUI(JTextField text) {
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = new JFrame("It's battle time!");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(
                5,5));

        JPanel topPanel = new JPanel();
        topPanel.setLayout((new GridLayout(1,
                1,5,5)));

        JTextArea playerStats = new JTextArea(
                2,10);
        playerStats.setBorder(BorderFactory
                .createTitledBorder(
                "Player"));

        JTextArea enemyStats = new JTextArea(
                2,10);
        enemyStats.setBorder(BorderFactory
                .createTitledBorder(
                "Enemy"));

        topPanel.add(playerStats);
        topPanel.add(enemyStats);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0,
                1,5,5));

        JTextArea battleArea = new JTextArea(
                10,10);
        battleArea.setWrapStyleWord(true);
        battleArea.setLineWrap(true);

        JScrollPane battleScroll = new JScrollPane();
        battleScroll.setBorder(BorderFactory
                .createTitledBorder(
                "Battle Text"));
        battleScroll.setViewportView(battleArea);

        centerPanel.add(battleScroll);

        JPanel bottomPanel = new JPanel();

        JButton attack = new JButton("attack");
        attack.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleArea.append("Attack\n");
                playerStats.setText("health\n");
                enemyStats.setText("health\n");
            }
        }));
        JButton special = new JButton("special");
        special.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                battleArea.append("Special Attack\n");
            }
        });
        JButton close = new JButton("close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        bottomPanel.add(attack);
        bottomPanel.add(special);
        bottomPanel.add(close);


        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
