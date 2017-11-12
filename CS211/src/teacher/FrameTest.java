package teacher;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.add(new JButton("Click"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
