import javax.swing.*;
import java.lang.StringBuilder;

public class GUI extends Threaded {
    private static ButtonFrame frame = new ButtonFrame();
    private StringBuilder stringBulder = new StringBuilder();

    public GUI() {
        super();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    @Override
    public void doRun() {
        while (true) {
            stringBulder.setLength(0);
            try { Thread.sleep(500); } catch (Exception e) { System.out.println("Error in gui"); }
            for (Threaded t : ThreadMonitor.activeTasks) {
                stringBulder.append(t.toString());
                stringBulder.append("\n");
            }
            frame.rewriteText(stringBulder.toString());
        }
    }
}

class ButtonFrame extends JFrame {
    ButtonPanel panel = null;

    public ButtonFrame() {
        setBounds(500,1000,700,600);
        setTitle("Вывод");
        panel=new ButtonPanel("\n");
        add(panel);
    }

    public void rewriteText(String s) {
        panel.textArea.setText(s);
    }
}

class ButtonPanel extends JPanel {
    JTextArea textArea=new JTextArea(100,50);

    public ButtonPanel(String str) {
        add(textArea);
        textArea.append(str);
        textArea.setLineWrap(true);
    }
}