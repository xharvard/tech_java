package core1.p11;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MouseComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	private List<Rectangle2D> rects;
	private Rectangle2D cur;
	private static final int LENGTH = 20;

	public MouseComponent() {
		rects = new ArrayList<Rectangle2D>();
		cur = null;
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle2D rect : rects) {
			g2.draw(rect);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 200);
	}

	private Rectangle2D find(Point2D point) {
		for (Rectangle2D rect : rects) {
			if (rect.contains(point))
				return rect;
		}
		return null;
	}

	private void add(Point2D point) {
		double x = point.getX();
		double y = point.getY();
		Rectangle2D rect = new Rectangle2D.Double(x - LENGTH / 2, y - LENGTH / 2, LENGTH, LENGTH);
		rects.add(rect);
		repaint();
	}

	private void remove(Rectangle2D rect) {
		if (rect == null)
			return;
		if (rect == cur)
			cur = null;
		rects.remove(rect);
		repaint();
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			cur = find(e.getPoint());
			if (cur != null && e.getClickCount() >= 2)
				remove(cur);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			cur = find(e.getPoint());
			if (cur == null)
				add(e.getPoint());
		}

	}

	private class MouseMotionHandler extends MouseMotionAdapter {

		@Override
		public void mouseDragged(MouseEvent e) {
			if (cur != null) {
				int x = e.getX();
				int y = e.getY();
				cur.setFrame(x - LENGTH / 2, y - LENGTH / 2, LENGTH, LENGTH);
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (find(e.getPoint()) == null) {
				setCursor(Cursor.getDefaultCursor());
			} else {
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MouseComponent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
