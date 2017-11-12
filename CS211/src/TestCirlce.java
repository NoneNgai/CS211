import javax.swing.JFrame;

public class TestCirlce {
	public static void main(String[] args) {
		CircleArtPanel CA = new CircleArtPanel();
		JFrame F = new JFrame();
		F.add(CA);
		F.setSize(1920, 1080);
		F.setDefaultCloseOperation(F.EXIT_ON_CLOSE);
		F.setVisible(true);
	}

}
