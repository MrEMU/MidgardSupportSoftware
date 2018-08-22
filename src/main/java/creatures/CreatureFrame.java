package main.java.creatures;

import main.java.util.CreatureRessources;

import javax.swing.*;
import java.awt.*;

public class CreatureFrame extends JFrame {

    CreaturePanel panel;

    public CreatureFrame() {
        panel = new CreaturePanel(this);
        CreatureRessources.init();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Midgard Kreaturen Lexikon");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width / 8, screenSize.height / 8, screenSize.width / 2, screenSize.height / 2);
        setPreferredSize(new Dimension(screenSize.width / 2, screenSize.height / 2));
        setResizable(false);
        pack();
        setVisible(true);
        repaint();
    }
}
