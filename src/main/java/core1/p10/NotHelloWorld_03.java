package core1.p10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class NotHelloWorld_03 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			NotHelloWorldFrame frame = new NotHelloWorldFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("NotHelloWorld");
			frame.setVisible(true);
		});
	}

}

class NotHelloWorldFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public NotHelloWorldFrame() {
		add(new NotHelloWorldComponent());
		pack();
	}
}

class NotHelloWorldComponent extends JComponent {
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		g.drawString("Not a Hello, World program", 75, 75);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300, 200);
	}

}