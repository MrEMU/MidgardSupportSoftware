package main.java.title;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorDialog extends JDialog implements ActionListener {

    JButton button;

    public ErrorDialog() {
        setLayout(new GridLayout(2,1));
        add(new JLabel("Error 404: Not Implemented yet!"));
        initButton();

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(screensize.width / 8, screensize.height/8));
        setLocation(screensize.width/2, screensize.height/2);
        setTitle("ERROR MESSAGE!");
        setVisible(true);
        pack();
    }

    public void initButton() {
        button = new JButton("Okay");
        button.addActionListener(this);
        button.setSize(new Dimension(getSize().width/4, getSize().height/4));
        button.setVisible(true);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dispose();
    }
}
