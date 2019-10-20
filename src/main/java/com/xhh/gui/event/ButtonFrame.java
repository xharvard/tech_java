package com.xhh.gui.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	public ButtonFrame() {
		setSize(WIDTH, HEIGHT);

		JButton yellowButton = new JButton("yellow");
		JButton blueButton = new JButton("blue");
		JButton redButton = new JButton("red");
		buttonPanel = new JPanel();

		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);

		add(buttonPanel);

		ColorListener yellowListener = new ColorListener(Color.YELLOW);
		ColorListener blueListener = new ColorListener(Color.BLUE);
		ColorListener redListener = new ColorListener(Color.RED);

		yellowButton.addActionListener(yellowListener);
		blueButton.addActionListener(blueListener);
		redButton.addActionListener(redListener);

	}

	private class ColorListener implements ActionListener {
		private Color bgColor;

		public ColorListener(Color c) {
			bgColor = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(bgColor);
		}

	}
	
	public static void main(String[] args) {
		ButtonFrame frame = new ButtonFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
