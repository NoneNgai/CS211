import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Assign2_CirclesThings.ControlsPanel;
public class ColorCircle{
	private Color color;
	private double x,y,radius,angle;
	ControlsPanel con = new ControlsPanel();
	public ColorCircle(double x,double y,double radius,Color color,double angle) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		Random ran = new Random();
		angle = ran.nextInt(360);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String toString() {
		return "Color = "+getColor();
	}

}
