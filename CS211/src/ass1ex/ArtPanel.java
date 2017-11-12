package ass1ex;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.management.InstanceNotFoundException;
import javax.management.timer.TimerMBean;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.Timer;

public class ArtPanel extends JPanel{
	JPanel P = new JPanel();
	public ArtPanel() {
		P.setSize(400, 300);
		P.isVisible();
		P.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D) g;
		int width = 100;
		int height = 60;
		gg.setColor(Color.BLUE);
		gg.fillRect(P.getWidth()/2, (P.getHeight()/2)-height, width, height);
		gg.drawLine(P.getWidth()/2, 0, P.getWidth()/2, P.getHeight());
		gg.drawLine(0, P.getHeight()/2, P.getWidth(), P.getHeight()/2);
			}
}

