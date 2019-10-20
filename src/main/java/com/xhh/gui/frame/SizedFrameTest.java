package com.xhh.gui.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizedFrameTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SizedFrame frame = new SizedFrame();
			frame.setTitle("SizedFrame"); // 设置标题
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			// frame.setExtendedState(Frame.MAXIMIZED_BOTH); //设置窗口状态
		});
	}
}

class SizedFrame extends JFrame {
	public SizedFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize(); // 获取屏幕大小
		int sWidth = dimension.width;
		int sHeight = dimension.height;

		setSize(sWidth / 2, sHeight / 2);
		setLocationByPlatform(true); // 由平台自动定位

		// Image image = toolkit.getImage(this.getClass().getResource("java.gif")); 
		Image image = new ImageIcon("java.gif").getImage();
		setIconImage(image); // 设置图标
	}
}