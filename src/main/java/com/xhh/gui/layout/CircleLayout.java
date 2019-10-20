package com.xhh.gui.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Iterator;

/**
 * 自定义布局管理器
 *
 */
public class CircleLayout implements LayoutManager {

	private boolean sizesSet = false;
	private int preferedWidth = 0;
	private int preferedHeight = 0;
	private int minWidth = 0;
	private int minHeight = 0;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;

	@Override
	public void addLayoutComponent(String name, Component comp) {

	}

	@Override
	public void removeLayoutComponent(Component comp) {

	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = preferedWidth + insets.left + insets.right;
		int height = preferedHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = minWidth + insets.left + insets.right;
		int height = minHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}

	@Override
	public void layoutContainer(Container parent) {
		setSizes(parent);

		Insets insets = parent.getInsets();
		int containerWidth = parent.getSize().width - insets.left - insets.right;
		int containerHeight = parent.getSize().height - insets.top - insets.bottom;

		int xCenter = insets.left + containerWidth / 2;
		int yCenter = insets.top + containerHeight / 2;

		int xRadius = (containerWidth - maxComponentWidth) / 2;
		int yRadius = (containerHeight - maxComponentHeight) / 2;
		int radius = Math.min(xRadius, yRadius);

		int n = parent.getComponentCount();
		for (int i = 0; i < n; i++) {
			Component component = parent.getComponent(i);
			if (component.isVisible()) {
				double angle = 2 * Math.PI * i / n;
				int x = xCenter + (int) (Math.cos(angle) * radius);
				int y = yCenter + (int) (Math.cos(angle) * radius);

				Dimension dimension = component.getPreferredSize();
				component.setBounds(x - dimension.width / 2, y - dimension.height / 2, dimension.width,
						dimension.height);
			}
		}
	}

	public void setSizes(Container parent) {
		if (sizesSet)
			return;

		int n = parent.getComponentCount();
		preferedWidth = 0;
		preferedHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;

		for (int i = 0; i < n; i++) {
			Component component = parent.getComponent(i);
			if (component.isVisible()) {
				Dimension dimension = component.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentWidth, dimension.width);
				maxComponentHeight = Math.max(maxComponentHeight, dimension.height);
				preferedWidth += dimension.width;
				preferedHeight += dimension.height;
			}
		}
		minWidth = preferedWidth / 2;
		minHeight = preferedHeight / 2;
		sizesSet = true;
	}
}
