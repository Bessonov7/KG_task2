import javax.swing.*;

public class Main {
    private JPanel root;
    private DrawPanel drawPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        drawPanel = new DrawPanel();
    }
}
