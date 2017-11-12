package teacher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse is clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse is pressed");
		MyPanel p = (MyPanel)e.getSource();
		if (e.getButton() == e.BUTTON1){
//			p.draw(e.getX(),e.getY());
		}else {
//			p.remove();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse is released");
		
	}

}
