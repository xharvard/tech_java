package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JTextField JPasswordField JLabel JTextArea JScrollPane
 *
 */
public class TextComponentFrame extends JFrame {

	public TextComponentFrame() {
		JTextField textField = new JTextField();
		JPasswordField passwordField = new JPasswordField();

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		add(northPanel, BorderLayout.NORTH);

		JTextArea textArea = new JTextArea(8, 20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		JButton button = new JButton("Insert");
		southPanel.add(button);
		button.addActionListener(event -> {
			textArea.append("User name: " + textField.getText() + " Password: "
					+ new String(passwordField.getPassword()) + "\n");
		});
		add(button, BorderLayout.SOUTH);
		pack();
	}

	public static void main(String[] args) {
		JFrame frame = new TextComponentFrame();
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
