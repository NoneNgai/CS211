package teacher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFrame extends JFrame {

	private JLabel label;
	private JTextField text;
	private JButton button;
	
	public TextFrame(){
		label = new JLabel("");
		text = new JTextField(10);
		button = new JButton("Set");
		
		JPanel p = new JPanel();
		p.add(text);
		p.add(button);
		p.add(label);
		
		this.add(p);
		label.setBackground(Color.PINK);
		label.setOpaque(true);
		label.setFont(new Font("Consolas", Font.BOLD, 18));
		label.setForeground(Color.RED);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(text.getText());
				
			}
		});
		text.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//label.setText(text.getText().toUpperCase() );
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				int cnt = Integer.parseInt(text.getText());
				label.setText(text.getText().toUpperCase() );
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//label.setText(text.getText().toUpperCase() );
				
			}
		});
		
		this.setSize(new Dimension(200,300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		TextFrame f = new TextFrame();
		
	}

}
