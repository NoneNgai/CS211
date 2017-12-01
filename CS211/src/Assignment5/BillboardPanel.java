package Assignment5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class BillboardPanel extends JPanel implements ActionListener{
	JLabel display,input;
	JTextField field;
	JButton add;
	Timer t;
	LinkedList<Character> In = new LinkedList<>();
	LinkedList<Character> Out = new LinkedList<>();
	char[] output = new char[10];
	char[] wordinput = new char[10];
	String wordin ="";
	public BillboardPanel() {
		this.setLayout(new BorderLayout());
		this.add(Word(), BorderLayout.CENTER);
		this.add(UI(),BorderLayout.SOUTH);
	}
	private JPanel Word() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		display = new JLabel("XXXXXXXXXX");
		input = new JLabel();
		display.setFont(new Font("", Font.BOLD, 90));
		input.setFont(new Font("", Font.PLAIN, 15));
		panel.add(display);
		panel.add(input);
		return panel;
	}
	private JPanel UI() {
		JPanel panel = new JPanel();
		field = new JTextField(20);
		add = new JButton("Add");
		add.setActionCommand("Add");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<field.getText().length();i++) {
					In.add(field.getText().charAt(i));
				}
				if(Out.isEmpty()) {
				for(int i=0;i<10;i++) {
					Out.add('X');
					}
				}
				t.start();
				field.setText("");
			}
		});
		t = new Timer(500, this);
		panel.add(field);
		panel.add(add);
		
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		Out.poll();
		Out.add(In.poll());
		if(Out.getLast()==null) {
			Out.removeLast();
			Out.addLast('X');
		}
		String wordout = "";
		for(int i=0;i<Out.size();i++) {
			wordout = wordout + Out.get(i);
		}
		String wordin = "";
		for(int i=0;i<In.size();i++) {
			wordin = wordin + In.get(i);
		}
		display.setText(wordout);
		input.setText(wordin);
	}
}
