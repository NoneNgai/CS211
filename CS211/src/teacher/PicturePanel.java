package teacher;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	ImageIcon img1 = new ImageIcon("kitty.jpg");
	ImageIcon img2 = new ImageIcon("kuma.jpg");
	ImageIcon img3 = new ImageIcon("oichi.jpg");
	int currentPic = 3;
	PicturePanel(){
		this.setPreferredSize(new Dimension(200,200));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (currentPic){
			case 1: g.drawImage(img1.getImage(), 0, 0,200,200, null); break;
			case 2: g.drawImage(img2.getImage(), 0, 0,200,200,null);break;
			case 3: g.drawImage(img3.getImage(), 0, 0,200,200,null);break;
			
		}
	}
	public void setImg(int id){
		this.currentPic = id;
		repaint();
	}
}
