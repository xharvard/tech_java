package core1.p10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class FontTest_05 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			FontFrame frame = new FontFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Font Test");
			frame.setVisible(true);
		});
	}
}

class FontFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public FontFrame() {
		add(new FontComponent());
		pack();
	}
}

class FontComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		String message = "Hello, World。pg!";
		
		Font font = new Font("Serif", Font.BOLD, 36);
		g2.setFont(font);
		
		//get the size of the message
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(message, context);
		
		double x = (getWidth() - bounds.getWidth() ) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		
		g2.drawString(message, (int)x, (int)baseY);
		
		//draw base line
		g2.setColor(Color.RED);
		g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
		
		Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
		g2.draw(rect);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(400, 200);
	}

}
