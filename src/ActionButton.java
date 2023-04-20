import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//Adding a button that never got used
public class ActionButton implements ActionListener {

    private int num = 0;
    //adding what it is supposed to be saying.

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("more hello" + num);
        num++;
    }

}
