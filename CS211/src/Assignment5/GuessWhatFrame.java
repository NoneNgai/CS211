package Assignment5;

import javax.swing.JFrame;

public class GuessWhatFrame extends JFrame{
	public GuessWhatFrame() {
		GuessWhatPanel panel = new GuessWhatPanel();
		this.add(panel);
	}
	public static void main(String[] args) {
		GuessWhatFrame frame = new GuessWhatFrame();
		frame.setTitle("GuessWhat!!!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
