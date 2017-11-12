import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Clock;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClockFrame extends JFrame implements ActionListener {
	public ClockFrame(Clock clock) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		String option = Dialog();
		if(option.equalsIgnoreCase("1")) { ///Digital clock
			DigitalClock c = new DigitalClock();
			this.add(new DigitalClock());
		}
		else if(option.equalsIgnoreCase("2")) { ///Analog clock
			AnalogClock c1 = new AnalogClock();
			this.add(new AnalogClock());
		}
		else {
			JOptionPane p = new JOptionPane();
			p.setMessageType(JOptionPane.ERROR_MESSAGE);
			p.setMessage("Error");
			JDialog p2 = p.createDialog("ERROR");
			p2.setVisible(true);
		}
		this.setVisible(true);
	}
	public void initTime() {
		
		
	}
	public static String Dialog() {
		JOptionPane p = new JOptionPane();
		p.setWantsInput(true);
		p.setMessageType(JOptionPane.QUESTION_MESSAGE);
		p.setMessage("Enter type of clock (1.Digital,2. Analog) 1 or 2");
		JDialog p1 = p.createDialog("Input");
		p1.setVisible(true);
		String opt = (String) p.getInputValue();
		return opt;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) {
		ClockFrame f = new ClockFrame(null);
		DigitalClock dg = new DigitalClock();
	}

}
