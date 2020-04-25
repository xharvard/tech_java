package core1.p10;

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
			ImageFrame frame = new ImageFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Image Test");
			frame.setVisible(true);
		});
	}

}

class ImageFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public ImageFrame() {
		add(new ImageComponent());
		pack();
	}
}

class ImageComponent extends JComponent{

	private static final long serialVersionUID = 1L;
	
	private Image image;
	
	public ImageComponent() {
		image = new ImageIcon("src/main/java/icon.jpg").getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		if(image == null)
			return;
		
		int w = image.getWidth(this);
		int h = image.getHeight(this);
		g.drawImage(image, 0, 0, null);
		
		for (int i = 0; i * w <= getWidth(); i ++) {
			for (int j = 0; j * h <= getHeight(); j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, w, h, i * w, j * h);
				}
			}
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000, 600);
	}
	
}