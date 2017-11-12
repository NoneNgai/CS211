package teacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PictureFrame extends JFrame implements ActionListener{
	private PicturePanel pPanel;
	PictureFrame(){
		pPanel = new PicturePanel();
		JButton btn1 = new JButton("Kitty", new ImageIcon("pikachu.png"));
		btn1.setActionCommand("1");
		btn1.setForeground(Color.CYAN);
		JButton btn2 = new JButton("Kuma");
		btn2.setActionCommand("2");
		
		
		JPanel p = new JPanel();
		p.add(pPanel);
		p.add(btn2);
		p.add(btn1);
		
		this.add(p);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
//		btn1.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				pPanel.setImg(1);
//			}
//			
//		});
//		btn2.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				pPanel.setImg(2);
//			}
//			
//		});
		
		this.setSize(250, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		PictureFrame frame = new PictureFrame();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String picId = e.getActionCommand();
		pPanel.setImg(Integer.parseInt(picId));
	}

}
