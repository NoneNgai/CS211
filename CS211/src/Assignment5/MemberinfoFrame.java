package Assignment5;

import javax.swing.JFrame;

public class MemberinfoFrame extends JFrame{
	MemberinfoPanel panel = new MemberinfoPanel();
	public MemberinfoFrame() {
		this.add(panel);
	}
	public static void main(String[] args) {
		MemberinfoFrame frame = new MemberinfoFrame();
		frame.setTitle("Member Info");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
