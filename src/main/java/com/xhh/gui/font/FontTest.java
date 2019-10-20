package com.xhh.gui.font;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 *
 */
public class FontTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new FontFrame();
			frame.setTitle("Font Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

class FontFrame extends JFrame {
	public FontFrame() {
		add(new FontComponent());
		pack();
	}
}

class FontComponent extends JComponent {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		String message = "java: Hello, World!";
		Font font = new Font("Serif", Font.BOLD, 36); // 第三个参数为点数目。 每英寸包含72个点
		g2.setFont(font);

		FontRenderContext context = g2.getFontRenderContext(); // 设备字体属性描述对象
		Rectangle2D bounds = font.getStringBounds(message, context);

		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;

		double ascent = -bounds.getY(); // 字体上坡度
		double baseY = y + ascent; // 字体的y坐标指的是基线位置

		g2.drawString(message, (int) x, (int) baseY);
		g2.setPaint(Color.LIGHT_GRAY);
		g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY)); //draw base line
		
		Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
		g2.setPaint(Color.RED);
		g2.draw(rect);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}
