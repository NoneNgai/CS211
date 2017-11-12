package Assignment3_DayColorFortune;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DayOfColorPanel extends JPanel{
	JPanel Left,Right;
	public DayOfColorPanel() {
		Left = new JPanel();
		Right = new JPanel();
		this.setPreferredSize(new Dimension(400, 200));
		Left.setBorder(new TitledBorder("Lucky Color"));
		Right.setBorder(new TitledBorder("Unlucky Color"));
		this.setLayout(new GridLayout(0, 2));
		this.add(Left);
		this.add(Right);
	}

}
