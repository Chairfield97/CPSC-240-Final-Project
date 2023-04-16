import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class PromptOutputStream extends OutputStream {
    private JTextArea prompt;
    public PromptOutputStream(JTextArea prompt) {
        this.prompt = prompt;
    }

    public void write(int b) throws IOException {
        // redirects data to the text area
        prompt.setText(prompt.getText() + String.valueOf((char)b));
        // scrolls the text area to the end of data
        prompt.setCaretPosition(prompt.getDocument().getLength());
        // keeps the textArea up to date
        prompt.update(prompt.getGraphics());
    }
}
