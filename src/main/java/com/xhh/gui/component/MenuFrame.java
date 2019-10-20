package com.xhh.gui.component;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuFrame extends JFrame {

	private Action saveAction, saveAsAction;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popupMenu;

	public MenuFrame() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new TestAction("New"));

		JMenuItem openItem = fileMenu.add(new TestAction("Open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

		fileMenu.addSeparator();

		saveAction = new TestAction("Save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

		saveAsAction = new TestAction("Save As");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();

		fileMenu.add(new AbstractAction("Exit") {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		readonlyItem = new JCheckBoxMenuItem("Read-only");
		readonlyItem.addActionListener(event -> {
			boolean saveOk = !readonlyItem.isSelected();
			saveAction.setEnabled(saveOk);
			saveAsAction.setEnabled(saveOk);
		});

		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("Insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("Overtype");
		group.add(insertItem);
		group.add(overtypeItem);

		Action cutAction = new TestAction("Cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("buttles.png"));
		Action copyAction = new TestAction("Copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("buttles.png"));
		Action pasteAction = new TestAction("Paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("buttles.png"));

		JMenu editMenu = new JMenu("Edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);

		JMenu optionMenu = new JMenu("Options");
		optionMenu.add(readonlyItem);
		optionMenu.addSeparator();
		optionMenu.add(insertItem);
		optionMenu.add(overtypeItem);

		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');

		JMenuItem indexItem = new JMenuItem("Index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);

		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(optionMenu);
		menuBar.add(helpMenu);

		popupMenu = new JPopupMenu();
		popupMenu.add(cutAction);
		popupMenu.add(copyAction);
		popupMenu.add(pasteAction);

		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popupMenu);
		add(panel);
	}

	class TestAction extends AbstractAction {

		public TestAction(String name) {
			super(name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(getValue(Action.NAME) + " selected.");
		}

	}

	public static void main(String[] args) {
		JFrame frame = new MenuFrame();
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
