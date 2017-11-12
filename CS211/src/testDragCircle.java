import javax.swing.JFrame;

public class testDragCircle {

	public static void main(String[] args) {
		DragCircle Dc = new DragCircle();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1920, 1080);
		f.add(Dc);
		f.setVisible(true);

	}

}
