package EXPCalc.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import EXPCalc.Calc.*;

public class CalcFrame extends JFrame {

	static EXPTable midgard;

	JMenuBar menubar;
	JMenu start;
	JMenuItem rechner;
	JMenuItem table;
	JMenuItem reset;

	JMenuItem EXPTableManager;

	JPanel EXPTable;
	JTable exp;

	JPanel mainPanel;
	JPanel north;

	JPanel east;
	JTextArea description = new JTextArea(20, 20);

	JPanel center;
	JPanel closeCombat;
	JPanel cast;
	JPanel ability;
	JPanel heal;
	JButton healcalc;
	JPanel util;
	JButton utilcalc;
	JButton combatcalc;
	JButton castcalc;
	JButton addAbilityExp;
	JCheckBox monsterkill;
	JTextField dmg;
	JTextField grad;
	JTextField amount;
	JTextField ap;
	JCheckBox rescue;

	JPanel west;
	JComboBox<String> character;

	JPanel south;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Constructor to setup the GUI components
	public CalcFrame() {

		initializeMenuBar();

		// MainPanel
		mainPanel = new JPanel(new BorderLayout());

		// North Panel
		north = new JPanel(new FlowLayout(FlowLayout.CENTER));
		north.add(new JLabel("Willkommen zum Midgard EXP Rechner!"));
		mainPanel.add(north, BorderLayout.NORTH);

		initializeCenterPanel();
		initializeWestPanel();

		// East Panel
		east = new JPanel(new FlowLayout(FlowLayout.LEFT));
		description.setText("Es wurde ein Nahkampfangriff ausgef�hrt.");
		description.setWrapStyleWord(true);
		description.setLineWrap(true);
		description.setEditable(false);
		east.add(description);
		mainPanel.add(east, BorderLayout.EAST);

		// South Panel
		south = new JPanel(new FlowLayout());
		south.add(new JLabel("       "));
		mainPanel.add(south, BorderLayout.SOUTH);

		// EXPTable Panel
		EXPTable = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String[] columnNames = { "Charakter", "EXP" };
		String[][] data = midgard.getData();
		exp = new JTable(data, columnNames);
		exp.setEnabled(false);
		EXPTable.add(exp);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainPanel);
		setTitle("Midgard EXP Calculator");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width / 2, screenSize.height / 2);
		pack();
		setVisible(true);
	}

	//Initialisierungsfunktionen
	public static void initiateTable(EXPTable midgard) {
		EXPNode fafnir = new EXPNode("Fafnir");
		EXPNode brock = new EXPNode("Brock");
		EXPNode luana = new EXPNode("Luana");
		EXPNode lacrima = new EXPNode("Lacrima");
		EXPNode gaiden = new EXPNode("Gaiden");
		EXPNode ilcoron = new EXPNode("Ilcoron");
		EXPNode nafdar = new EXPNode("Nafdar");
		midgard.add(fafnir);
		midgard.add(brock);
		midgard.add(luana);
		midgard.add(lacrima);
		midgard.add(gaiden);
		midgard.add(ilcoron);
		midgard.add(nafdar);
	}

	public void showEXPTableManager() {
		new EXPTableManager(this).setVisible(true);
	}

	public void initializeMenuBar() {
		// MenuBar and Items
		menubar = new JMenuBar();

		start = new JMenu("Start");
		start.setMnemonic(KeyEvent.VK_A);
		start.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");

		rechner = new JMenuItem("Rechner");
		rechner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(mainPanel);
			}
		});

		table = new JMenuItem("EXP Table");
		table.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTable();
				changeContentPane(EXPTable);
			}
		});

		reset = new JMenuItem("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				midgard.resetData();
				updateTable();
				changeContentPane(EXPTable);
			}
		});

		EXPTableManager = new JMenuItem("Charaktere Verwalten");
		EXPTableManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showEXPTableManager();
			}
		});

		// Add items to menubar
		menubar.add(start);
		start.add(rechner);
		start.add(table);
		start.add(reset);
		menubar.add(EXPTableManager);

		setJMenuBar(menubar);
	}

	public void initializeWestPanel() {
		// West Panel
		west = new JPanel(new GridLayout(2, 2));
		west.add(new JLabel("W�hle Charakter: "));
		String[] chars = midgard.getNames();
		character = new JComboBox<String>(chars);
		west.add(character);
		west.add(new JLabel("W�hle Aktion: "));
		String[] actions = { "Nahkampf", "Zauber/Fernkampf", "Fertigkeit", "Heilzauber", "anderer Zauber" };
		JComboBox<String> actionType = new JComboBox<String>(actions);
		actionType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				String type = (String) cb.getSelectedItem();
				description.setText(CalcFrame.descriptionHandler(type));
			}
		});
		actionType.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent evt) {
			    CardLayout cl = (CardLayout)(center.getLayout());
			    cl.show(center, (String)evt.getItem());
			}
		});
		west.add(actionType);
		mainPanel.add(west, BorderLayout.WEST);
	}

	public void initializeCenterPanel() {
		// Combat Center Panel
		closeCombat = new JPanel(new GridLayout(3, 2));
		closeCombat.add(new JLabel("Schaden: "));
		dmg = new JTextField(5);
		closeCombat.add(dmg);
		closeCombat.add(new JLabel("Grad des Feindes: "));
		grad = new JTextField(5);
		closeCombat.add(grad);
		monsterkill = new JCheckBox("Monsterkill");
		closeCombat.add(monsterkill);
		combatcalc = new JButton("Hinzuf�gen");
		combatcalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				combatExpHandler();
			}
		});
		closeCombat.add(combatcalc);
		center = new JPanel(new CardLayout());
		center.add(closeCombat, "Nahkampf");
		mainPanel.add(center, BorderLayout.CENTER);

		
		// Cast Center Panel
		cast = new JPanel(new GridLayout(3, 2));
		cast.add(new JLabel("Schaden: "));
		dmg = new JTextField(5);
		cast.add(dmg);
		cast.add(new JLabel("Grad des Feindes: "));
		grad = new JTextField(5);
		cast.add(grad);
		monsterkill = new JCheckBox("Monsterkill");
		cast.add(monsterkill);
		cast.add(new JLabel("   "));
		cast.remove(5);
		castcalc = new JButton("Hinzuf�gen");
		castcalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				castExpHandler();
			}
		});
		cast.add(castcalc);
		center.add(cast, "Zauber/Fernkampf");

		// Ability Center Panel
		ability = new JPanel(new GridLayout(3,1));
		ability.add(new JLabel("    "));
		addAbilityExp = new JButton("Fertigkeit ausgef�hrt");
		addAbilityExp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abilityExpHandler();
			}
		});
		ability.add(addAbilityExp);
		center.add(ability, "Fertigkeit");

		// Heal Center Panel
		heal = new JPanel(new GridLayout(3, 2));
		heal.add(new JLabel("Heal Amount: "));
		amount = new JTextField(5);
		heal.add(amount);
		heal.add(new JLabel("AP Kosten: "));
		ap = new JTextField(5);
		heal.add(ap);
		rescue = new JCheckBox("Life Rescue");
		heal.add(rescue);
		healcalc = new JButton("Hinzuf�gen");
		healcalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				healExpHandler();
			}
		});
		heal.add(healcalc);
		center.add(heal, "Heilzauber");

		// Utility Spells Center Panel
		util = new JPanel(new GridLayout(2, 2));
		util.add(new JLabel("AP Kosten: "));
		ap = new JTextField(5);
		util.add(ap);
		util.add(new JLabel("     "));
		utilcalc = new JButton("Hinzuf�gen");
		utilcalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				utilityExpHandler();
			}
		});
		util.add(utilcalc);
		center.add(util, "anderer Zauber");
	}

	//EXP Handler
	public void combatExpHandler() {
		JTextField dmgField = (JTextField) closeCombat.getComponent(1);
		JTextField gradField = (JTextField) closeCombat.getComponent(3);
		JCheckBox monsterkillBox = (JCheckBox) closeCombat.getComponent(4);
		int dmg = Integer.parseInt(dmgField.getText());
		int grad = Integer.parseInt(gradField.getText());
		boolean monsterkill = monsterkillBox.isSelected();
		int exp = Calculator.getCloseCombatExp(dmg, grad, monsterkill);
		JComboBox<String> ch = (JComboBox<String>) west.getComponent(1);
		String name = (String) ch.getSelectedItem();
		for (EXPNode node : midgard) {
			if (node.getName().equals(name)) {
				node.addToExp(exp);
				JLabel msg = (JLabel) south.getComponent(0);
				msg.setText(name + " hat " + exp + " EXP erhalten.");
				return;
			}
		}
		JLabel msg = (JLabel) south.getComponent(0);
		msg.setText("Charakter nicht gefunden.");
	}
	
	public void castExpHandler() {
		JTextField dmgField = (JTextField) cast.getComponent(1);
		JTextField gradField = (JTextField) cast.getComponent(3);
		JCheckBox monsterkillBox = (JCheckBox) cast.getComponent(4);
		int dmg = Integer.parseInt(dmgField.getText());
		int grad = Integer.parseInt(gradField.getText());
		boolean monsterkill = monsterkillBox.isSelected();
		int exp =  (int) Math.ceil((double) Calculator.getCloseCombatExp(dmg, grad, monsterkill)/2);
		JComboBox<String> ch = (JComboBox<String>) west.getComponent(1);
		String name = (String) ch.getSelectedItem();
		for (EXPNode node : midgard) {
			if (node.getName().equals(name)) {
				node.addToExp(exp);
				JLabel msg = (JLabel) south.getComponent(0);
				msg.setText(name + " hat " + exp + " EXP erhalten.");
				return;
			}
		}
		JLabel msg = (JLabel) south.getComponent(0);
		msg.setText("Charakter nicht gefunden.");
	}

	public void utilityExpHandler() {
		JTextField apField = (JTextField) util.getComponent(1);
		int ap = Integer.parseInt(apField.getText());
		int exp = Calculator.getSpellExp(ap);
		JComboBox<String> ch = (JComboBox<String>) west.getComponent(1);
		String name = (String) ch.getSelectedItem();
		for (EXPNode node : midgard) {
			if (node.getName().equals(name)) {
				node.addToExp(exp);
				JLabel msg = (JLabel) south.getComponent(0);
				msg.setText(name + " hat " + " EXP erhalten.");
				return;
			}
		}
		JLabel msg = (JLabel) south.getComponent(0);
		msg.setText("Charakter nicht gefunden.");
	}

	public void abilityExpHandler() {
		JComboBox<String> ch = (JComboBox<String>) west.getComponent(1);
		String name = (String) ch.getSelectedItem();
		for (EXPNode node : midgard) {
			if (node.getName().equals(name)) {
				node.addToExp(5);
				JLabel msg = (JLabel) south.getComponent(0);
				msg.setText(name + " hat 5 EXP erhalten.");
				return;
			}
		}
		JLabel msg = (JLabel) south.getComponent(0);
		msg.setText("Charakter nicht gefunden.");
	}

	public void healExpHandler() {
		JTextField healField = (JTextField) heal.getComponent(1);
		JTextField apField = (JTextField) heal.getComponent(3);
		JCheckBox monsterkillBox = (JCheckBox) heal.getComponent(4);
		int heal = Integer.parseInt(healField.getText());
		int ap = Integer.parseInt(apField.getText());
		boolean rescue = monsterkillBox.isSelected();
		int exp = Calculator.getHealSpellExp(ap, heal, rescue);
		JComboBox<String> ch = (JComboBox<String>) west.getComponent(1);
		String name = (String) ch.getSelectedItem();
		for (EXPNode node : midgard) {
			if (node.getName().equals(name)) {
				node.addToExp(exp);
				JLabel msg = (JLabel) south.getComponent(0);
				msg.setText(name + " hat " + exp + " EXP erhalten.");
				return;
			}
		}
		JLabel msg = (JLabel) south.getComponent(0);
		msg.setText("Charakter nicht gefunden.");
	}

	//Hilfsfunktionen
	public static String descriptionHandler(String type) {
		if (type == "Nahkampf")
			return "Es wurde ein Nahkampfangriff ausgef�hrt.";
		if (type == "Zauber/Fernkampf")
			return "Es wurde ein Angriffszauber oder eine Fernkampfwaffe verwendet.";
		if (type == "Fertigkeit")
			return "Es wurde erfolgreich eine Fertigkeit eingesetzt.";
		if (type == "Heilzauber")
			return "Es wurde ein Heilzauber verwendet.";
		else
			return "Es wurde ein Zauber verwendet.";
	}

	public void changeContentPane(JPanel panel) {
		setContentPane(panel);
		getContentPane().revalidate();
		getContentPane().repaint();
	}

	public void updateTable() {
		String[] columnNames = { "Charakter", "EXP" };
		String[][] data = midgard.getData();
		exp = new JTable(data, columnNames);
		exp.setEnabled(false);
		EXPTable.removeAll();
		EXPTable.add(exp);
	}

	//Main
	public static void main(String[] args) {
		// Initialization
		midgard = new EXPTable();
		initiateTable(midgard);
		// Invoke the constructor (to setup the GUI) by allocating an instance
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CalcFrame(); // Let the constructor do the job
			}
		});
	}

}
