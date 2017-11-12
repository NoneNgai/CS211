
public class Circle {
	private int x,y,radius;
	public Circle(int x,int y,int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return (Math.PI*Math.pow(getRadius(), 2));
	}
	public String toString() {
		return "X = "+getX()+" Y = "+getY()+" Radius = "+getRadius();
	}
}
