package core1.p10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawTest_04 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			DrawFrame frame = new DrawFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("DrawTest");
			frame.setVisible(true);
		});
	}
}

class DrawFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		add(new DrawComponent());
		pack();
	}

}

class DrawComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		//draw a rectangle
		Rectangle2D rect = new Rectangle2D.Double(100, 100, 200, 150);
		g2.draw(rect);
		
		//draw a ellipsse
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.draw(ellipse);
		
		//draw a line
		g2.draw(new Line2D.Double(100, 100, 100 + 200, 100 + 150));
		
		//draw a circle
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		double radius = 150;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + 150);
		g2.setPaint(Color.RED);
		g2.draw(circle);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 400);
	}

}