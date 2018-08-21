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
        setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 4, screenSize.height / 4);
        setPreferredSize(new Dimension(screenSize.width / 4, screenSize.height / 4));
        setResizable(false);
        pack();
        setVisible(true);
        repaint();
    }
}
