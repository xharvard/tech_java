package core1.p10;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SimpleFrameTest_01 {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SimpleFrame frame = new SimpleFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setUndecorated(true);
			frame.setVisible(true);
		});
	}

}

class SimpleFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public SimpleFrame() {
		setSize(300, 200);
	}

}
