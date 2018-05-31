package Title;

import EXPCalc.GUI.CalcFrame;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class TitlePanel extends JPanel {

    TitleFrame title;

    JButton exp;
    JButton plants;
    JButton animals;
    JButton weather;

    public TitlePanel(TitleFrame t) {
        setLayout(null);
        title = t;
        setUpButtons();
        initListeners();
    }

    public void setUpButtons() {
        exp = new JButton("EXP Calc Program");
        exp.setFont(new Font("Times new Roman", 0, 20));
        exp.setSize(200, 40);
        exp.setLocation(250, 150);
        exp.setVisible(true);
        plants = new JButton("Plant Randomizer");
        plants.setFont(new Font("Times new Roman", 0, 20));
        plants.setSize(200, 40);
        plants.setLocation(250, 200);
        plants.setVisible(true);
        animals = new JButton("Animal Randomizer");
        animals.setFont(new Font("Times new Roman", 0, 20));
        animals.setSize(200, 40);
        animals.setLocation(250, 250);
        animals.setVisible(true);
        weather = new JButton("Weather Randomizer");
        weather.setFont(new Font("Times new Roman", 0, 20));
        weather.setSize(200, 40);
        weather.setLocation(250, 300);
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

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times New Roman", 1, 42));
        g.drawString("Midgard Support Software", 90, 70);
    }
}
