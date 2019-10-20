package com.xhh.gui.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class NotHelloWorld {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new NotHelloWorldFrame();
			frame.setTitle("NotHelloWorld");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

class NotHelloWorldFrame extends JFrame {

	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent()); // 将组件添加到该框架的内容窗格中
		pack(); // 用组件的首选大小布局，即调用getPreferredSize()
	}
}

class NotHelloWorldComponent extends JComponent {
	private static final int MESSAGE_X = 75;
	private static final int MESSAGE_Y = 100;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}