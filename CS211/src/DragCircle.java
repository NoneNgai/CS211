import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DragCircle extends JPanel{
	private int tmp;
	static SimulatedCircles sim;
	private DrawMouseListener x ;
	private Ellipse2D.Double circle, circledrag;

	public DragCircle() {
		sim = new SimulatedCircles(1500, 500, 100);
		sim.generateCircles(20);
		x = new DrawMouseListener();
		this.addMouseListener(x);
		this.addMouseMotionListener(x);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		for (int i = 0; i < sim.Size(); i++) {
			if (sim.getByIndex(i).getRadius() > tmp)
				tmp = sim.getByIndex(i).getRadius();
		}
			for (int i = 0; i < sim.C.size(); i++) {
				circle = new Ellipse2D.Double(sim.getByIndex(i).getX(), sim.getByIndex(i).getY(),
						sim.getByIndex(i).getRadius() * 2, sim.getByIndex(i).getRadius() * 2);
				if (sim.getByIndex(i) instanceof ColorCircle) {
					ColorCircle cir = (ColorCircle) sim.getByIndex(i);

					if (sim.getByIndex(i).getRadius() == tmp) {
						gg.setColor(cir.getColor());
						gg.fill(circle);
					} else {
						gg.setColor(cir.getColor());
						gg.draw(circle);
					}
				} else if (sim.getByIndex(i) instanceof Circle) {
					if (sim.getByIndex(i).getRadius() == tmp) {
						gg.fill(circle);
					} else {
						gg.draw(circle);
					}
				}
			}
		}
	public class DrawMouseListener implements MouseListener,MouseMotionListener{
		private boolean start = true;
		private int x1, y1,x2,y2, tmp;
		private double dis;
		private int rad;
		Color color;

		public void mouseDragged(MouseEvent e) {
			start = true;
			x2 = e.getX();
			y2 = e.getY();
			
		}

		public void mousePressed(MouseEvent e) {
			if (start == true && e.getButton() != 3) {
				x1 = e.getX();
				y1 = e.getY();
				start = false;
			}
		}

		public void mouseClicked(MouseEvent e) {
			if (SwingUtilities.isRightMouseButton(e)) {
				Color test = Color.RED;
				color = JColorChooser.showDialog(new DragCircle(), "Select a color", test);
			}
		}
		public void mouseReleased(MouseEvent e) {
			dis = Point2D.distance(x1, y1, x2, y2);
			rad = (int) Math.round(dis);
				if(start == true)
					sim.add(new ColorCircle(x1-rad, y1-Math.round(rad), rad, color));
			repaint();		
		}
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
}
}
