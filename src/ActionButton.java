import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ActionButton implements ActionListener {

    private int num = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("more hello" + num);
        num++;
    }

}
