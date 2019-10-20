package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButtonFrame extends JFrame {
	private JPanel panel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;

	public RadioButtonFrame() {
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);

		panel = new JPanel();
		group = new ButtonGroup();

		addRadioButton("Small", 8);
		addRadioButton("Medium", 12);
		addRadioButton("Large", 18);
		addRadioButton("Extra large", 36);

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	private void addRadioButton(String name, int size) {
		boolean selected = size == DEFAULT_SIZE;
		JRadioButton radioButton = new JRadioButton(name, selected);
		group.add(radioButton);
		panel.add(radioButton);
		radioButton.addActionListener(event -> {
			label.setFont(new Font("Serif", Font.PLAIN, size));
		});
	}

	public static void main(String[] args) {
		JFrame frame = new RadioButtonFrame();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
