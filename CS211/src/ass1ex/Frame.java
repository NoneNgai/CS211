package ass1ex;

import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JFrame;

public class Frame  extends JFrame{
	ArtPanel p = new ArtPanel();
	public Frame() {
		add(p);
		setSize(400, 300);
		setBounds(getMaximizedBounds());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		Frame f = new Frame();		
	}

}
