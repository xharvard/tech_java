package core1.p11;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class PlafFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;

	public PlafFrame() {
		buttonPanel = new JPanel();

		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo info : infos) {
			makeButton(info.getName(), info.getClassName());
		}

		add(buttonPanel);
		pack();

	}

	private void makeButton(String name, String className) {
		JButton button = new JButton(name);
		buttonPanel.add(button);

		button.addActionListener(event -> {
			try {
				UIManager.setLookAndFeel(className);
				SwingUtilities.updateComponentTreeUI(this);
				pack();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}

		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			PlafFrame frame = new PlafFrame();
			frame.setTitle("Look And Feel Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}
