import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimulatedCircles{
	private int maxX, maxY, maxRadius, tmp, tmp1;
	Circle cb, cs;
	ArrayList<Circle> C;

	public SimulatedCircles(int maxX, int maxY, int maxRadius) {
		C = new ArrayList<>();
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxRadius = maxRadius;
	}

	public void generateCircles(int number) {
		Random r = new Random();
		for (int i = 0; i < number; i++) {
			if(r.nextInt(2)==0)
			C.add(new Circle(r.nextInt(maxX), r.nextInt(maxY), r.nextInt(maxRadius)));
			if(r.nextInt(2)==1)
			C.add(new ColorCircle(r.nextInt(maxX), r.nextInt(maxY), r.nextInt(maxRadius)));
		}
	}

	public void add(Circle c) {
		C.add(c);
	}

	public Circle getBiggestArea() {

			for (int i = 0; i < C.size(); i++) {
				tmp = C.get(i).getRadius();
				if (tmp > tmp1) {
					tmp1 = tmp;
					cb = C.get(i);
			}
		}
			return cb;
	}

	public Circle getSmallestArea() {
		for (int i = 0; i < C.size(); i++) {
			tmp = C.get(i).getRadius();
			if (tmp < tmp1) {
				tmp1 = tmp;
				cs = C.get(i);
			}
		}
		return cs;

	}

	public Circle getByIndex(int index) {
		return C.get(index);

	}

	public int Size() {
		return C.size();
	}
}
