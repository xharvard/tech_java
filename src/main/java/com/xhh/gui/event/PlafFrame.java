package com.xhh.gui.event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * 某些jdk中不存在swing.properties，根据java文档描述，如果不存在的话，就手动添加该文件到jre/lib的文件夹下。是jdk目录下的jre/lib。
 * 然后在该文件中添加以下内容：
 * #swing.defaultlaf = javax.swing.plaf.metal.MetalLookAndFeel
 * #swing.defaultlaf = com.sun.java.swing.plaf.motif.MotifLookAndFeel
 * #swing.defaultlaf = com.sun.java.swing.plaf.windows.WindowsLookAndFeel
 * swing.defaultlaf = com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
 * 其中#后面的内容是被注释掉的。且如果有两行没有#，则以最后一次的设置为准。
 */
public class PlafFrame extends JFrame {

	private JPanel buttonPanel;

	public PlafFrame() {
		buttonPanel = new JPanel();

		// 已安装的观感
		UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : infos) {
			System.out.println(info.getName() + ", " + info.getClassName());
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new PlafFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
