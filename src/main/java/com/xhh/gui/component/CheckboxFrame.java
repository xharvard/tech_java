package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CheckboxFrame extends JFrame {
	private JLabel label;
	private JCheckBox bold, italic;
	private static final int FONT_SIZE = 24;

	public CheckboxFrame() {
		label = new JLabel("The quick brown fox jumps over the lazy dog.");
		label.setFont(new Font("Serif", Font.BOLD, FONT_SIZE));
		add(label, BorderLayout.CENTER);

		ActionListener listener = event -> {
			int mode = 0;
			if (bold.isSelected())
				mode += Font.BOLD;
			if (italic.isSelected())
				mode += Font.ITALIC;
			label.setFont(new Font("Serif", mode, FONT_SIZE));
		};

		JPanel panel = new JPanel();
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		bold.setSelected(true);
		panel.add(bold);

		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		panel.add(italic);

		add(panel, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		JFrame frame = new CheckboxFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
