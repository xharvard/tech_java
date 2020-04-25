package core1.p10;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SizedFrameTest_02 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SizedFrame frame = new SizedFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

class SizedFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public SizedFrame() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Toolkit toolkit2 = getToolkit();  获取到的ToolKit为同一个
		Dimension screenSize = toolkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screenHeight / 2);
		setLocationByPlatform(true);

		Image image = new ImageIcon("src/main/java/icon.jpg").getImage();
		setIconImage(image);
	}
}