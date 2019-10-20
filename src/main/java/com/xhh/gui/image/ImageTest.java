package com.xhh.gui.image;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class ImageTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new ImageFrame();
			frame.setTitle("Image Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

class ImageFrame extends JFrame {
	public ImageFrame() {
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	private Image image;

	public ImageComponent() {
		image = new ImageIcon("baidu.png").getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (image == null) {
			return;
		}

		int imageW = image.getWidth(this);
		int imageH = image.getHeight(this);

		g.drawImage(image, 0, 0, null);

		// 复制
		for (int i = 0; i * imageW <= getWidth(); i++) {
			for (int j = 0; j * imageH <= getHeight(); j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, imageW, imageH, i * imageW, j * imageH);
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
