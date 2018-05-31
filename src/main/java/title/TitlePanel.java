package main.java.title;

import main.java.expCalc.gui.CalcFrame;
import main.java.plants.PlantFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TitlePanel extends JPanel {

    TitleFrame title;
    String path = "src/main/resources/";

    JButton exp;
    JButton plants;
    JButton animals;
    JButton weather;

    Image header;

    public TitlePanel(TitleFrame t) {
        setLayout(null);
        title = t;
        setUpButtons();
        initListeners();
        try {
            header = javax.imageio.ImageIO.read(new File(path + "Titel.JPG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpButtons() {
        exp = new JButton("EXP Calc Program");
        exp.setFont(new Font("Times new Roman", 0, 20));
        exp.setSize(200, 40);
        exp.setLocation(235, 180);
        exp.setVisible(true);
        plants = new JButton("Kr\u00e4uter Generator");
        plants.setFont(new Font("Times new Roman", 0, 20));
        plants.setSize(200, 40);
        plants.setLocation(235, 230);
        plants.setVisible(true);
        animals = new JButton("Tier Generator");
        animals.setFont(new Font("Times new Roman", 0, 20));
        animals.setSize(200, 40);
        animals.setLocation(235, 280);
        animals.setVisible(true);
        weather = new JButton("Wetter Generator");
        weather.setFont(new Font("Times new Roman", 0, 20));
        weather.setSize(200, 40);
        weather.setLocation(235, 330);
        weather.setVisible(true);

        add(exp);
        add(plants);
        add(animals);
        add(weather);
    }

    private void initListeners() {
        exp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalcFrame();
            }
        });
        plants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlantFrame();
            }
        });
        animals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        weather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(path + "Wetter.pdf"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(header, 200, 20, header.getWidth(this) / 2, header.getHeight(this) / 2, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", 1, 42));
        g.drawString("Support Software", 175, 130);
    }
}
