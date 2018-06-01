package main.java.title;

import javax.swing.*;
import java.awt.*;

public class TitleFrame extends JFrame {

    TitlePanel panel;

     public TitleFrame() {
         panel = new TitlePanel(this);
         setContentPane(panel);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setTitle("Midgard Support Software");
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);
         setPreferredSize(new Dimension(screenSize.width / 2 - 290, screenSize.height / 2));
         setResizable(false);
         pack();
         setVisible(true);
         repaint();
     }

    //Main
    public static void main(String[] args) {
        // Invoke the constructor (to setup the gui) by allocating an instance
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TitleFrame(); // Let the constructor do the job
            }
        });
    }
}
