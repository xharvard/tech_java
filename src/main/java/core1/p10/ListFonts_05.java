package core1.p10;

import java.awt.GraphicsEnvironment;

public class ListFonts_05 {

	public static void main(String[] args) {
		String[] fontStrings = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String str : fontStrings) {
			System.out.println(str);
		}
	}
}
