package main.java.plants;

import main.java.util.PlantRessources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PlantPanel extends JPanel {

    PlantFrame plantFrame;
    JPanel leftPanel;
    JPanel rightPanel;
    JScrollPane scrollPane;

    JComboBox<String> area = new JComboBox<>();
    JTextField count = new JTextField();
    JButton generate;
    JButton special;

    JTextArea output = new JTextArea();

    public PlantPanel(PlantFrame p) {
        plantFrame = p;
        setLayout(new GridLayout(1, 2));
        initPanels();
        initItems();
        initListeners();
    }

    private void initPanels() {
        leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Times New Roman", 0, 18));
                g.drawString("W\u00e4hle das Gebiet:", 20, 35);
                g.drawString("W\u00e4hle die Anzahl:", 20, 85);
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
        String[] areas = {"Garten", "Wiese","Wald","Lichtung","Gebirge", "Gew\u00e4sser"};
        area = new JComboBox<>(areas);
        area.setFont(new Font("Times New Roman", 0, 20));
        area.setSize(130, 20);
        area.setLocation(20, 40);
        area.setVisible(true);
        count = new JTextField();
        count.setFont(new Font("Times New Roman", 0, 20));
        count.setSize(130, 20);
        count.setLocation(20, 90);
        count.setVisible(true);
        generate = new JButton("Generieren!");
        generate.setFont(new Font("Times New Roman", 0, 20));
        generate.setSize(130, 30);
        generate.setLocation(20, 140);
        generate.setVisible(true);
        special = new JButton("Spezial");
        special.setFont(new Font("Times New Roman", 0, 20));
        special.setSize(130, 30);
        special.setLocation(20, 180);
        special.setVisible(true);
        output = new JTextArea();
        output.setFont(new Font("Times New Roman", 0, 18));
        output.setSize(200, this.getHeight());
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        output.setVisible(true);
        scrollPane = new JScrollPane(output);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        leftPanel.add(area);
        leftPanel.add(count);
        leftPanel.add(generate);
        leftPanel.add(special);
        rightPanel.add(scrollPane);
    }

    private void initListeners() {
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c = count.getText();
                if(!c.matches("[0-9]+")) {
                    if(c.isEmpty()) output.setText("Bitte gib eine Anzahl ein!");
                    else output.setText("Bitte nutze nur Zahlen um die Anzahl anzugeben!");
                    return;
                }
                int count = Integer.parseInt(c);
                int a = area.getSelectedIndex();
                ArrayList<String> gens = getRandomPlants(a, count);
                updateOutput(gens);
            }
        });
        special.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateOutput(PlantRessources.getSpecial());
            }
        });
    }

    private ArrayList<String> getRandomPlants(int area, int count) {
        ArrayList<String> plants = new ArrayList<>();
        ArrayList<String> generated = new ArrayList<>();
        switch (area) {
            case 0: plants = new ArrayList<>(PlantRessources.getGarden());
                    break;
            case 1: plants = new ArrayList<>(PlantRessources.getMeadow());
                    break;
            case 2: plants = new ArrayList<>(PlantRessources.getForest());
                    break;
            case 3: plants = new ArrayList<>(PlantRessources.getGlade());
                    break;
            case 4: plants = new ArrayList<>(PlantRessources.getMountains());
                    break;
            case 5: plants = new ArrayList<>(PlantRessources.getWaters());
                    break;
            default: System.out.println("Something went wrong!");
                     return generated;
        }
        if(count>plants.size()){
            output.setText("Bitte w\u00e4hle eine kleinere Anzahl, dieses Gebiet besitzt leider nur " + plants.size() + " Pflanzen.");
            return generated;
        }
        int random;
        for(int i = 0; i < count; i++){
            random = ThreadLocalRandom.current().nextInt(0, plants.size());
            generated.add(plants.get(random));
            plants.remove(random);
        }
        return generated;
    }

    private void updateOutput(ArrayList<String> plants) {
        if(plants.isEmpty()) {
            output.setText(output.getText() + "\nEtwas ist bei der Generierung der Pflanzen schief gelaufen!");
            return;
        }
        String out = "";
        for(String element: plants) {
            out = out + element + "\n";
        }
        output.setText(out);
    }
}
