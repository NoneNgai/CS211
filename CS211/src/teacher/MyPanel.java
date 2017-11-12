package teacher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener{
	
	ArrayList<Rectangle2D.Double> rects = new ArrayList<Rectangle2D.Double> ();
	ImageIcon image = new ImageIcon("oichi.jpg");
	Color c = Color.MAGENTA;
	Rectangle2D.Double rect = new Rectangle2D.Double();
	
	Timer time;
	
	public MyPanel(){
		this.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		//MyMouseListener listener = new MyMouseListener();
		//this.addMouseListener(listener);
		this.addMouseListener(new MouseAdapter(){

			public void mousePressed(MouseEvent e) {
				if (e.getButton() ==1){
					draw(e.getX(),e.getY());
				}else{
					remove();
				}
			}
		});
		this.addMouseListener(new ColorMouseListener(Color.BLUE));
		
		time = new Timer(1000,this);
		//time.start();
		rect.setRect(0, 0, 20, 20);
	}
	
	private void draw(int x, int y){
		Random ran= new Random();
		int w = ran.nextInt(200);
		int h = ran.nextInt(200);
		Rectangle2D.Double rect = new Rectangle2D.Double();
		rect.setRect(x-w/2, y-h/2, w, h);
		rects.add(rect);
		
		repaint();
	}
	private void remove(){
		if (rects.size() >0)
			rects.remove(0);
		
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(image.getImage(), 0, 0, null);
		
		
		g.setColor(new Color(0,0,255));
		
		for (Rectangle2D.Double r: rects){
			g.fillRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
		}
		//		Graphics2D g2d = (Graphics2D)g;
//		g2d.draw(rect);
//		
//		g.drawRect(50, 80, 60, 40);
//		g.drawString("XXXXXXXXXX", 50, 80);
//		
//		g.setColor(new Color(0,255,0));
		g.drawLine (0,0,this.getWidth(),this.getHeight());
		
		g.setColor(this.c);
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(rect);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random ran = new Random();
		draw(ran.nextInt(400), ran.nextInt(400));
		
	}
	
	class ColorMouseListener implements MouseListener{
		private Color color;
		ColorMouseListener(Color c){
			this.color = c;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			c = color;
			rect.setRect(e.getX(), e.getY(), rect.getWidth(), rect.getHeight());
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
