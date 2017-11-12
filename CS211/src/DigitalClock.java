import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DigitalClock extends JPanel {
	private JLabel jl;
	private Timer t;
	ImageIcon im = new ImageIcon("pikachu.jpg");

	public DigitalClock() {
		jl = new JLabel("");
		setLayout(new GridLayout());
		jl.setLocation(500, 500);
		add(jl);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		jl.setFont(new Font("Tahoma", Font.BOLD, 50));
		jl.setForeground(Color.BLACK);
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jl.setText(DateFormat.getTimeInstance().format(new Date()));
			}
		});
		t.setRepeats(true);
		t.setCoalesce(true);
		t.setInitialDelay(0);
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
