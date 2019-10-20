package com.xhh.gui.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {

	private JPanel slidePanel;
	private JTextField textField;
	private ChangeListener listener;

	public SliderFrame() {
		slidePanel = new JPanel();
		slidePanel.setLayout(new GridLayout());
		listener = event -> {
			JSlider slider = (JSlider) event.getSource();
			textField.setText("" + slider.getValue());
		};

		JSlider slider = new JSlider();
		addSlider(slider, "Plain");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap to ticks");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "No track");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");

		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);

		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom labels");
		
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);

		labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel(new ImageIcon("buttles.png")));
		labelTable.put(20, new JLabel(new ImageIcon("buttles.png")));
		labelTable.put(40, new JLabel(new ImageIcon("buttles.png")));
		labelTable.put(60, new JLabel(new ImageIcon("buttles.png")));
		labelTable.put(80, new JLabel(new ImageIcon("buttles.png")));
		labelTable.put(100, new JLabel(new ImageIcon("buttles.png")));
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon labels");
		
		textField = new JTextField();
		add(slidePanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
		pack();
	}

	private void addSlider(JSlider slider, String desc) {
		slider.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(slider);
		panel.add(new JLabel(desc));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = slidePanel.getComponentCount();
		gbc.anchor = GridBagConstraints.WEST;
		slidePanel.add(panel, gbc);
	}

	public static void main(String[] args) {
		JFrame frame = new SliderFrame();
		frame.setSize(1600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
