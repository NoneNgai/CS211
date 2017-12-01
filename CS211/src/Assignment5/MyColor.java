package Assignment5;

import java.awt.Color;

public enum MyColor {
	RED(Color.RED),BLUE(Color.BLUE), GREEN(Color.GREEN);
	private Color c;
	private MyColor(Color c) {
		this.c = c;
	}
	public Color getColor() {
		return c;
	}
}
