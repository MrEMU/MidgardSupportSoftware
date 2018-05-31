package expCalc.gui;

import expCalc.calc.EXPNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Window for managing characters
 */
public class EXPTableManager extends JFrame {

    /**
     * Custom JPanel explicitly for managing characters
     */
    private class NodeManagerPanel extends JPanel {

        public JTextField newNodeName;

        /**
         * Constructor for NodeManagerPanel
         *
         * Adds all characters with corresponding buttons
         * as well as a textfield for new characters
         *
         * @param father Reference to the EXPTableManager window
         */
        public NodeManagerPanel(EXPTableManager father) {
            // NodeManagerPanel is always a JPanel with 3 cols and exactly known rows
            super(new GridLayout(CalcFrame.midgard.size() + 3, 3));

            // heading row
            this.add(new JLabel("Charakter"));
            this.add(new JLabel());                     // spacing
            this.add(new JLabel("Entfernen?"));

            // add every name and button
            for(EXPNode node : CalcFrame.midgard) {
                this.add(new JLabel(node.getName()));
                this.add(new JLabel());                 // spacing

                JButton deleteNode = new JButton("X");
                deleteNode.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        CalcFrame.midgard.remove(node);

                        // update EXPTableManager window and main window
                        father.updateAll();
                    }
                });
                this.add(deleteNode);
            }

            // heading for new character
            this.add(new JLabel("Name des neuen Charakters:"));
            this.add(new JLabel());
            this.add(new JLabel());

            // textfield and button for new character
            newNodeName = new JTextField();
            newNodeName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(!newNodeName.getText().isEmpty()) {
                        CalcFrame.midgard.add(new EXPNode(newNodeName.getText()));

                        father.updateAll();
                    }
                }
            });
            this.add(newNodeName);

            this.add(new JLabel());                     // spacing

            JButton submitNewNode = new JButton("OK");
            submitNewNode.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(!newNodeName.getText().isEmpty()) {
                        CalcFrame.midgard.add(new EXPNode(newNodeName.getText()));

                        father.updateAll();
                    }
                }
            });
            this.add(submitNewNode);
        }
    }

    /**
     * Content Panel
     */
    public NodeManagerPanel mainPanel;
    /**
     * Reference to the main window
     */
    public CalcFrame mainGui;

    /**
     * Constructor for EXPTableManager window
     *
     * @param mainGui Reference to the main window
     */
    public EXPTableManager(CalcFrame mainGui) {
        // create a new content panel with reference to the EXPTableManager window
        mainPanel = new NodeManagerPanel(this);
        // store reference to the main window
        this.mainGui = mainGui;

        // initialize EXPTableManager window
        setContentPane(mainPanel);
        setTitle("Charaktere Verwalten");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width / 2, screenSize.height / 2);
        pack();

        // set the focus on the textfield
        mainPanel.newNodeName.requestFocusInWindow();
    }

    /**
     * Updates the content pane when a character is added or removed
     */
    public void updatePane() {
        mainPanel = new NodeManagerPanel(this);
        setContentPane(mainPanel);
        getContentPane().revalidate();
        getContentPane().repaint();

        // set the focus on the textfield
        mainPanel.newNodeName.requestFocusInWindow();
    }

    /**
     * Update the contents of EXPTableManager window, EXPTable and ComboBox from main window
     */
    public void updateAll() {
        // update myself
        updatePane();

        // update JTable from main window
        mainGui.updateTable();

        // update ComboBox from main window
        String[] characters = CalcFrame.midgard.getNames();
        DefaultComboBoxModel<String> newComboboxNames = new DefaultComboBoxModel<String>(characters);
        mainGui.character.setModel(newComboboxNames);

        // redraw current pane of main window
        mainGui.getContentPane().revalidate();
        mainGui.getContentPane().repaint();
    }
}
