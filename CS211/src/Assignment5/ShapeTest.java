package Assignment5;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class ShapeTest {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(new FlowLayout());
		ShapePanel p1 = new ShapePanel();
		p1.setShow(false);
		f.add(p1);
		ShapePanel p2 = new ShapePanel();
		p2.setShape(new Shape (ShapeType.TRIANGLE,MyColor.GREEN));
		p2.setShow(true);
		f.add(p2);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
