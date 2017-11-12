package Assign2_CirclesThings;

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
	ArrayList<ColorCircle> C;
	private boolean animate,merge,fill,nfill;
	private double angle;
	public CirclePanel() {
		C = new ArrayList<>();
		this.setPreferredSize(new Dimension(500, 500));
		this.setBorder(new LineBorder(Color.BLACK,2));
		t = new Timer(10,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int xPos[];
				int yPos[];
				int angle[];
				if(isAnimate()) {
					for(int i=0;i<C.size();i++) {
						xPos = new int[C.size()];
						yPos = new int[C.size()];
						angle = new int[C.size()];
						xPos[i] = (int)(C.get(i).getX()+(int)(5*Math.cos(Math.toRadians(C.get(i).getAngle()))));
						C.get(i).setX(xPos[i]);
						yPos[i] = (int)(C.get(i).getY()+(int)(5*Math.cos(Math.toRadians(C.get(i).getAngle()))));
						angle[i] = (int) C.get(i).getAngle();
						if(C.get(i).getX()<0|| C.get(i).getX() > getWidth() || C.get(i).getY()<0 || C.get(i).getY() > getHeight()) {
							System.out.println(angle[i]);
							angle[i] = (int) (C.get(i).getAngle() + 180);
							C.get(i).setAngle(angle[i] %360);
							System.out.println(angle[i]);
						}
						repaint();
					}
				}
				if(isMerge()) {
					
				}
			}
		});
		t.start();

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(animate) {
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
				}
			}
		}
		else {
			if(fill==true) {
				for(int i=0;i<C.size();i++) {
					g.setColor(C.get(i).getColor());
					g.fillOval((int)C.get(i).getX(),(int)C.get(i).getY(),(int)C.get(i).getRadius()*2,(int)C.get(i).getRadius()*2);
				}
			}
			else {
				for(int i=0;i<C.size();i++) {
					g.setColor(C.get(i).getColor());
					g.drawOval((int)C.get(i).getX(),(int)C.get(i).getY(),(int)C.get(i).getRadius()*2,(int)C.get(i).getRadius()*2);
				}
			}
		}	
	}
	public void add(ColorCircle c) {
		C.add(c);
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
	
}

