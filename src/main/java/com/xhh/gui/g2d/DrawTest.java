package com.xhh.gui.g2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new DrawFrame();
			frame.setTitle("Draw Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame {
	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}

}

class DrawComponent extends JComponent {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;

		// 矩形
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.draw(rect);

		// 椭圆
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);

		// 线
		g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;

		// 圆形
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
		g2.draw(circle);

		// 圆角矩形
		RoundRectangle2D roundRect = new RoundRectangle2D.Double(leftX + 10, topY + 10, width - 20, height - 20, 15,
				15);
		g2.setPaint(Color.RED);
		g2.draw(roundRect);

		// 圆弧( upper-left corner, width, height, start degree, extent degree,
		// type)
		Arc2D arc = new Arc2D.Double(30, 300, 100, 100, 0, 200, Arc2D.PIE);
		g2.setPaint(Color.GREEN);
		g2.fill(arc); // fill是填充颜色，draw是绘制区域

		// 二次曲线(start point, control point, end point)
		QuadCurve2D quad = new QuadCurve2D.Double(50, 50, 100, 170, 200, 220);
		g2.setPaint(Color.CYAN);
		g2.draw(quad);

		// 三次曲线(start point, first control point, second control point, end
		// point)
		CubicCurve2D cubic = new CubicCurve2D.Double(10, 20, 130, 40, 50, 150, 150, 250);
		g2.setPaint(Color.ORANGE);
		g2.fill(cubic);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}
}