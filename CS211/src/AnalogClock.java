import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnalogClock extends JPanel{
	private Ellipse2D.Double face,secondArm,minArm,hourArm;
	private Line2D.Double h,min,sec;
	private int ho,mi,se;
	Calendar cal;
	public AnalogClock() {
		this.setBackground(Color.GRAY);
		Timer t = new Timer(1000, new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				cal = Calendar.getInstance();
				ho = cal.get(Calendar.HOUR);
				mi = cal.get(Calendar.MINUTE);
				se = cal.get(Calendar.SECOND);
				repaint();
			}});
		t.start();
		t.setDelay(0);
	
	}
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D gg = (Graphics2D) g;
		super.paintComponent(g);
		face = new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight());									
		sec = new Line2D.Double(this.getWidth()/2, this.getHeight()/2, (this.getWidth()/2)+(180*Math.cos((90-se*6.0)*(Math.PI/180))), (this.getHeight()/2)-(180*Math.sin((90-se*6.0)*(Math.PI/180))));
		min = new Line2D.Double(this.getWidth()/2, this.getHeight()/2, (this.getWidth()/2)+(120*Math.cos((90-(mi+se/60.0)*6.0)*(Math.PI/180))), (this.getHeight()/2)-(120*Math.sin((90-(mi+se/60.0)*6.0)*(Math.PI/180))));
		h = new Line2D.Double(this.getWidth()/2, this.getHeight()/2, (this.getWidth()/2)+(60*Math.cos((90-(ho+mi/60.0)*30.0)*(Math.PI/180))), (this.getHeight()/2)-(60*Math.sin((90-(ho+mi/60.0)*30.0)*(Math.PI/180))));
		gg.setColor(Color.LIGHT_GRAY);
		gg.fill(face);
		gg.setColor(Color.RED);
		gg.setStroke(new BasicStroke(3f));
		gg.draw(sec);
		gg.setColor(Color.BLUE);
		gg.setStroke(new BasicStroke(5f));
		gg.draw(min);
		gg.setColor(Color.CYAN);
		gg.setStroke(new BasicStroke(7f));
		gg.draw(h);
	}
}
