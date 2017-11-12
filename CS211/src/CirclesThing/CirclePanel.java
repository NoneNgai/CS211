package CirclesThing;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class CirclePanel extends JPanel{
	Timer t;
	ArrayList<ColorCircle> C ;
	private boolean animate,merge,fill,nfill;
	private double angle;
	public CirclePanel() {
		C= new ArrayList<>();
		this.setPreferredSize(new Dimension(500, 500));
		this.setBorder(new LineBorder(Color.BLACK,2));
		Random ran = new Random();
		angle = ran.nextInt(360);
		t = new Timer(100,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*control.getxPos() += 5*Math.cos(Math.toRadians(angel));
				y += 5*Math.sin(Math.toRadians(angel));
				if(x<0||x > this.getWidth()||y<0||y>this.getHeight()){
					angel += 180;
					angel = angel%360;
				}
				repaint();
				*/
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
			if(fill) {
				for(int i=0;i<C.size();i++) {
					g.setColor(C.get(i).getColor());
					g.fillOval((int)C.get(i).getX(),(int)C.get(i).getY(),(int)C.get(i).getRadius()*2,(int)C.get(i).getRadius()*2);
				}
			}
			else {
				for(int i=0;i<C.size();i++) {
					g.setColor(C.get(i).getColor());
					g.drawOval((int)C.get(i).getX(),(int)C.get(i).getY(),(int)C.get(i).getRadius()*2,(int)C.get(i).getRadius()*2);
					System.out.println((int)C.get(i).getX());
				}
			}
			repaint();
		}	

	
	public void setAnimate(boolean animate) {
		this.animate = animate;
	}
	public void setMerge(boolean merge) {
		this.merge = merge;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public void setNfill(boolean nfill) {
		this.nfill = nfill;
	}
	public boolean isAnimate() {
		return animate;
	}
	public boolean isMerge() {
		return merge;
	}
	public boolean isFill() {
		return fill;
	}
	public boolean isNfill() {
		return nfill;
	}
	public void add(ColorCircle circle) {
		C.add(circle);
	}
}

