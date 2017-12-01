package Assignment5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ShapePanel extends JPanel {
	private boolean show = false;
	private Shape s;
	private int[] x = new int[3];
	private int[] y = new int[3];
	public ShapePanel() {
		this.setBorder(new LineBorder(Color.black, 3));
		setPreferredSize(new Dimension(100, 100));
	}

	public void setShow(boolean sh) {
		show = sh;
	}

	public void setShape(Shape ss) {
		s = ss;
	}

	public Shape getShape() {
		return s;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (show==true&&s!=null) {
			if (s.getType().equals(ShapeType.SQUARE)) {
				g.setColor(s.getColor());
				g.fillRect((this.getWidth()/12), (this.getHeight()/12),(this.getWidth()-this.getWidth()/6) ,(this.getHeight()-this.getHeight()/6) );
			}
			else if (s.getType().equals(ShapeType.CIRCLE)) {
				g.setColor(s.getColor());
				g.fillOval((this.getWidth()/12), (this.getHeight()/12),(this.getWidth()-this.getWidth()/6) ,(this.getHeight()-this.getHeight()/6) );
			}
			else if (s.getType().equals(ShapeType.TRIANGLE)) {
				for(int i=0;i<3;i++) {
					if(i==0)
					x[0] = (this.getWidth()/12);
					y[0] = (this.getHeight()-this.getHeight()/6);
					if(i==1)
					x[1] = (this.getWidth()-this.getWidth()/6);
					y[1] = (this.getHeight()-this.getHeight()/6);
					if(i==2)
					x[2] = this.getWidth()/2;
					y[2] = (this.getHeight()/12);
				}
				g.setColor(s.getColor());
				g.fillPolygon(x ,y , 3);
			}
		}
	}
}
