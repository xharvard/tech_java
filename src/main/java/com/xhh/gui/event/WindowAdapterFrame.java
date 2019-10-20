package com.xhh.gui.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 有些接口(WindowListener)的方法多于一个时，jdk提供了适配器类来避免实现多余的空方法。
 * 
 * 例如：WindowAdapter，只需实现自己需要的方法，其他方法已有默认空实现
 * 
 * 
 */
public class WindowAdapterFrame extends JFrame {

	public WindowAdapterFrame() {
		setSize(300, 200);
	}

	public static void main(String[] args) {
		JFrame frame = new WindowAdapterFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowListener());
		frame.setVisible(true);
	}

}

class WindowListener extends WindowAdapter {

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
