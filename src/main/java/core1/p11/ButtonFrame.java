package core1.p11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;

	public ButtonFrame() {
		setSize(600, 400);
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		buttonPanel = new JPanel();
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		add(buttonPanel);
		
		yellowButton.addActionListener(new ColorAction(Color.YELLOW));
		blueButton.addActionListener(new ColorAction(Color.BLUE));
		redButton.addActionListener(new ColorAction(Color.RED));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			ButtonFrame frame = new ButtonFrame();
			frame.setTitle("Action Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

	private class ColorAction implements ActionListener {

		private Color bgColor;
		
		public ColorAction(Color bgColor) {
			this.bgColor = bgColor;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			buttonPanel.setBackground(bgColor);
		}

	}

}
