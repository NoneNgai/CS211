package Assignment5;

import java.awt.Color;

public class Shape {
	ShapeType s;
	Color c;
	public Shape(ShapeType type,MyColor color) {
		s = type;
		c = color.getColor();	
	}
	public ShapeType getType() {
		return s;
	}
	public void setType(ShapeType type) {
		s = type;
	}
	public Color getColor() {
		return c;
	}
	public void setColor(Color color) {
		c = color;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (s != other.s)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		return 0;
	}
}
