package com.xhh.gui.layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorPanel extends JPanel {

	private JButton display;
	private JPanel panel;
	private double result;
	private String lastComand;
	private boolean start;

	public CalculatorPanel() {
		setLayout(new BorderLayout());
		result = 0;
		lastComand = "=";
		start = true;

		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);

		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));

		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);

		add(panel, BorderLayout.CENTER);
	}

	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}

	private class InsertAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}

	}

	private class CommandAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (start) {
				if ("-".equals(command)) {
					display.setText(command);
					start = false;
				} else
					lastComand = command;
			} else {
				calulate(Double.parseDouble(display.getText()));
				lastComand = command;
				start = true;
			}
		}

		private void calulate(double x) {
			if ("+".equals(lastComand))
				result += x;
			else if ("-".equals(lastComand))
				result -= x;
			else if ("*".equals(lastComand))
				result *= x;
			else if ("/".equals(lastComand))
				result /= x;
			else if ("=".equals(lastComand))
				result = x;
			display.setText("" + result);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new CalculatorPanel());
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
