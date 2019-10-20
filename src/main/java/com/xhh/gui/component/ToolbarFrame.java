package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolbarFrame extends JFrame {

	private JPanel panel;

	public ToolbarFrame() {
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		Action yellowAction = new ColorAction("Yellow", new ImageIcon("buttles.png"), Color.YELLOW);
		Action blueAction = new ColorAction("Blue", new ImageIcon("buttles.png"), Color.BLUE);
		Action redAction = new ColorAction("Red", new ImageIcon("buttles.png"), Color.RED);
		Action exitAction = new AbstractAction("Exit", new ImageIcon("buttles.png")) {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

		JToolBar toolBar = new JToolBar();
		toolBar.add(yellowAction);
		toolBar.add(blueAction);
		toolBar.add(redAction);
		toolBar.addSeparator();
		toolBar.add(exitAction);

		add(toolBar, BorderLayout.NORTH);

		JMenu menu = new JMenu("color");
		menu.add(yellowAction);
		menu.add(blueAction);
		menu.add(redAction);
		menu.addSeparator();
		menu.add(exitAction);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	public class ColorAction extends AbstractAction {

		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, name + " background");
			putValue("color", c);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color color = (Color) getValue("color");
			panel.setBackground(color);
		}

	}

	public static void main(String[] args) {
		JFrame frame = new ToolbarFrame();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
