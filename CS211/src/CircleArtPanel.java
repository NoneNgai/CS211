import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class CircleArtPanel extends JPanel {
	private Ellipse2D.Double circle;
	private int tmp;
	static SimulatedCircles sim;

	public CircleArtPanel() {
		sim = new SimulatedCircles(1500, 500, 100);
		sim.generateCircles(20);
	}

	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		for (int i = 0; i < sim.Size(); i++) {
			if (sim.getByIndex(i).getRadius() > tmp)
				tmp = sim.getByIndex(i).getRadius();
		}
		for (int i = 0; i < sim.Size(); i++) {
			circle = new Ellipse2D.Double(sim.getByIndex(i).getX(), sim.getByIndex(i).getY(), sim.getByIndex(i).getRadius() * 2,
					sim.getByIndex(i).getRadius() * 2);
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

}
