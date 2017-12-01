package Assignment5;

import javax.swing.JFrame;

public class BillboardFrame extends JFrame{
	public BillboardFrame() {
		this.add(new BillboardPanel());
	}
	public static void main(String[] args) {
		BillboardFrame frame = new BillboardFrame();
		frame.setTitle("BillBoard");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
	}
}
