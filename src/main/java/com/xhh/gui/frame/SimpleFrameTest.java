package com.xhh.gui.frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * 所有Swing组件必须由事件分派线程(event dispatch thread)进行配置，线程将鼠标点击和按键控制转移到用户接口组件。
 * EventQueue.invokeLater(() -> {statements});
 * 
 * 组件继承关系： Object <- Component <- Container <- Window <- Frame <- JFrame
 * 
 * Object <- Component <- Container <- JComponent <- JPanel
 *
 */
public class SimpleFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SimpleFrame frame = new SimpleFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// frame.setUndecorated(true); //去掉框架装饰(最小化、最大化、关闭等)，一个空窗体
			frame.setVisible(true); // 框架默认是不显示的，需要手动调用
		});
	}
}

class SimpleFrame extends JFrame {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	public SimpleFrame() {
		// 框架默认大小为0,需要手动设置
		setSize(WIDTH, HEIGHT);
		setLocation(100, 100); // 来自Component类，设置位置。相对于(0,0)位置的偏移
		setBounds(200, 200, WIDTH * 2, HEIGHT * 2); // 来自Component类,设置位置和大小。
	}
}
