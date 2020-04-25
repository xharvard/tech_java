package core1.p11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;

	public ActionFrame() {
		setSize(800, 600);
		buttonPanel = new JPanel();

		Action yellowAction = new ColorAction("Yellow", new ImageIcon("src/main/java/button.jgp"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("src/main/java/button.jgp"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("src/main/java/button.jgp"), Color.RED);

		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		add(buttonPanel);

		// associate the Y, B, and R Keys with names
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

		// associate the names with actions
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);

	}

	public class ColorAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public ColorAction(String name, Icon icon, Color color) {
			putValue(Action.NAME, name);
//			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", color);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = (Color) getValue("color");
			buttonPanel.setBackground(color);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			ActionFrame frame = new ActionFrame();
			frame.setTitle("Action Test");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}
