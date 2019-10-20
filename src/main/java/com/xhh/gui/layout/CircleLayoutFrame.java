package com.xhh.gui.layout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CircleLayoutFrame extends JFrame {

	public CircleLayoutFrame() {
		setLayout(new CircleLayout());
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		add(new JButton("Yellow"));
		pack();
	}

	public static void main(String[] args) {
		JFrame frame = new CircleLayoutFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
