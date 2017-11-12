package Assignment3_EngineMachine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Repeatable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class EnginePanel extends JPanel{
	private int rad=10;
	JButton Start;
	Status status = Status.OFF;
	Timer t;
	private int cnt=0;
	public EnginePanel() {
		this.setPreferredSize(new Dimension(300, 300));
		Start = new JButton("Press to start");
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Start.getText().equals("Press to start")) {
					System.out.println("eiei");
					t.start();
					status = status.nextState(true);
					Start.setText("STOP");
				}
				else if(Start.getText().equals("STOP")) {
					cnt=0;
					rad=10;
					status.OFF.nextState(false);
					status.WARMUP.nextState(false);
					status.RUNNING.nextState(false);
					t.stop();
					repaint();
				}
			}
		});
		t = new Timer(1000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				if(cnt==10) {
					status.WARMUP.nextState(true);
				}
				repaint();
			}
		});
		this.setLayout(new BorderLayout());
		this.add(Start, BorderLayout.SOUTH);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(t.isRunning()!=true) {
		g.setColor(status.OFF.getColor());
		g.drawString("OFF", 0, getHeight()-Start.getHeight());
		}
		if(t.isRunning()) {
			if(cnt<=10) {
			rad+=2;
			g.setColor(status.WARMUP.getColor());
			g.drawString("WARM UP", 0, getHeight()-Start.getHeight());
			}
			if(cnt>10) {
				rad+=20;
				g.setColor(status.RUNNING.getColor());
				g.drawString("RUNNING", 0, getHeight()-Start.getHeight());
			}
		}
		g.fillOval(getWidth()/2-rad,getHeight()/2-rad, rad*2, rad*2);
	}

}
