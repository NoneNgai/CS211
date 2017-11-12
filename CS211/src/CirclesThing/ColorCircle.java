package CirclesThing;


import java.awt.Color;
import java.util.Random;

public class ColorCircle {
	private Color color;
	private double x,y,radius,angle;
	ControlsPanel con = new ControlsPanel();
	public ColorCircle(double x,double y,double radius,Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		Random ran = new Random();
		angle = ran.nextInt(360);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String toString() {
		return "x " +x+"y ="+y+"Color = "+getColor();
	}

}
