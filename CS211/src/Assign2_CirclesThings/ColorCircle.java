package Assign2_CirclesThings;

import java.awt.Color;
import java.util.Random;

public class ColorCircle {
	private Color color;
	private double x, y, radius;
	private int angle;
	ControlsPanel con = new ControlsPanel();

	public ColorCircle(double x, double y, double radius, Color color,int angle) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		this.angle = angle;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String toString() {
		return "Color = " + getColor();
	}

}
