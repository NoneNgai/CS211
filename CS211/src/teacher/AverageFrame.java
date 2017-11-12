package teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AverageFrame extends JFrame{
	
	private JTextField result;
	private JTextArea numbers;
	private JButton button;
	
	public AverageFrame(){
		
		result = new JTextField(10);
		result.setEditable(false);
		
		numbers = new JTextArea(2, 10);
		button = new JButton("Ave");
		
		JPanel panel = new JPanel();
		panel.add(numbers);
		panel.add(result);
		panel.add(button);
		this.add(panel);
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String nums = numbers.getText();
				String data[] = nums.split(" ");
				int sum = 0;
				for (String d:data){
					sum += Integer.parseInt(d);
				}
				result.setText(""+ (float)sum/data.length);
				
			}});
		
		this.setSize(180,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String ... x){
		AverageFrame f = new AverageFrame();
	}

}
