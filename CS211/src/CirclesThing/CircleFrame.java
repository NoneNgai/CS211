package CirclesThing;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CircleFrame extends JFrame{
	ControlsPanel con = new ControlsPanel();
	JPanel panel = new JPanel();
	public CircleFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(con.getCon(),BorderLayout.CENTER);
		this.add(con,BorderLayout.EAST);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		CircleFrame Frame = new CircleFrame();
	}
}
