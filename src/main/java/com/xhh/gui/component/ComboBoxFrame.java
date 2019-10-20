package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxFrame extends JFrame {

	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int FONT_SIZE = 24;

	public ComboBoxFrame() {
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.PLAIN, FONT_SIZE));
		add(label, BorderLayout.CENTER);

		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SanSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");

		faceCombo.addActionListener(event -> {
			label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN, FONT_SIZE));
		});

		JPanel panel = new JPanel();
		panel.add(faceCombo);
		add(panel, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
