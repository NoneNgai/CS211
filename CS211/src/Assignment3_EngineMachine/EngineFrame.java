package Assignment3_EngineMachine;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EngineFrame extends JFrame{
	EnginePanel Panel;
	public EngineFrame() {
		Panel = new EnginePanel();
		this.add(Panel);
	}
	public static void main(String[] args) {
		EngineFrame ff = new EngineFrame();
		ff.setVisible(true);
		ff.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ff.pack();
		ff.setTitle("Engine Frame");
	}
}
