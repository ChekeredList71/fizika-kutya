package src;

import javax.swing.*;
import java.awt.*;

public class GUI {



    public void inputWindow() {

        JFrame frame = new JFrame("Futkosó kutya");
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel p1Label = new JLabel("1. személy sebessége:");
        JTextField p1Speed = new JTextField();
        JButton ok = new JButton("OK");


        panel.add(p1Label);
        panel.add(p1Speed);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2,
                Toolkit.getDefaultToolkit().getScreenSize().height/2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocationRelativeTo(null);

        frame.add(panel);

        frame.setVisible(true);
    }
}
