package com.xhh.gui.component;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class BorderFrame extends JFrame {
	private JPanel demoPanel, buttonPanel;
	private ButtonGroup group;

	public BorderFrame() {
		demoPanel = new JPanel();
		buttonPanel = new JPanel();
		group = new ButtonGroup();

		addRadioButton("Lowered bevel", BorderFactory.createLoweredBevelBorder());
		addRadioButton("Raised bevle", BorderFactory.createRaisedBevelBorder());
		addRadioButton("Etched", BorderFactory.createEtchedBorder());
		addRadioButton("Line", BorderFactory.createLineBorder(Color.BLUE));
		addRadioButton("Matte", BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
		addRadioButton("Empty", BorderFactory.createEmptyBorder());

		Border border = BorderFactory.createEtchedBorder();
		Border title = BorderFactory.createTitledBorder(border, "Border types");
		buttonPanel.setBorder(title);

		setLayout(new GridLayout(2, 1));
		add(buttonPanel);
		add(demoPanel);
		pack();
	}

	private void addRadioButton(String name, Border b) {
		JRadioButton radioButton = new JRadioButton(name);
		radioButton.addActionListener(event -> demoPanel.setBorder(b));
		group.add(radioButton);
		buttonPanel.add(radioButton);
	}

	public static void main(String[] args) {
		JFrame frame = new BorderFrame();
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
