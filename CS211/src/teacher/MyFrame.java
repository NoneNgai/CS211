package teacher;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame(String title){
		//this.setSize(300, 300);
		this.setTitle(title);
		MyPanel panel = new MyPanel();
		this.add(panel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
