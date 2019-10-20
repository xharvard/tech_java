package com.xhh.gui.font;

import java.awt.GraphicsEnvironment;

/**
 * 列出本机环境中的所有字体
 *
 */
public class ListFonts {

	public static void main(String[] args) {
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String fontName : fontNames)
			System.out.println(fontName);
	}

}
