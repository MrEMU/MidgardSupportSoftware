package main.java.creatures;

import javax.swing.*;
import java.awt.*;

public class CreaturePanel extends JPanel {

    CreatureFrame frame;
    JPanel leftPanel;
    JPanel rightPanel;

    JTable output;
    JScrollPane scrollPane;

    public CreaturePanel(CreatureFrame frame){
        this.frame = frame;
        setLayout(new GridLayout(1, 2));
        initPanels();
    }

    private void initPanels() {
        leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Times New Roman", 0, 18));
                g.drawString("W\u00e4hle die Region/Sonstiges:", 20, 35);
                g.drawString("W\u00e4hle die Teilregion/Kategorie:", 20, 85);
            }
        };
        leftPanel.setLayout(null);
        leftPanel.setSize(this.getWidth()/2, this.getHeight());
        add(leftPanel);
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1, 1));
        rightPanel.setSize(this.getWidth()/2, this.getHeight());
        add(rightPanel);
    }

    private void initItems() {

        String[] columnName = {"Kreatur"};
        Object[][] data = {{"Test"},{"Test"}};
        output = new JTable(data, columnName);
        output.setFont(new Font("Times New Roman", 0, 18));
        output.setSize(100, this.getHeight());
        output.setVisible(true);
        output.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(output);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        rightPanel.add(scrollPane);
    }
}
