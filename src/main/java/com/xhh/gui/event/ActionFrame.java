package com.xhh.gui.event;

import java.awt.Color;
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
	private JPanel buttonPanel;
	private static final int WIDTH = 300;
	private static final int HEIGHT = 200;

	public ActionFrame() {
		setSize(WIDTH, HEIGHT);
		buttonPanel = new JPanel();

		Action yellowAction = new ColorAction("Yellow", new ImageIcon("buttles.png"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("buttles.png"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("buttles.png"), Color.RED);

		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		add(buttonPanel);

		InputMap iMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		iMap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		iMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		iMap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

		ActionMap aMap = buttonPanel.getActionMap();
		aMap.put("panel.yellow", yellowAction);
		aMap.put("panel.blue", blueAction);
		aMap.put("panel.red", redAction);
	}

	public static void main(String[] args) {
		JFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public class ColorAction extends AbstractAction {

		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = (Color) getValue("color");
			buttonPanel.setBackground(color);
		}

	}

}
